package com.geek.service;

import com.geek.util.ConnectionUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ZParams;

import java.util.*;

/**
 * Created by Liuqi
 * Date: 2016/11/23.
 */
public class ArticleService {
    private static final int ONE_WEEK_IN_SECONDS = 7 * 86400;
    private static final int VOTE_SCORE = 432;
    private static final int ARTICLES_PER_PAGE = 25;
    private static Jedis redis;

    static {
        redis = ConnectionUtils.getSimpleConnecton();
    }

    public static final void main(String[] args) {
        new ArticleService().run();
    }

    public void run() {
        //redis.select(15);

        String articleId = postArticle(
                redis, "username", "A title", "http://www.google.com");
        System.out.println("We posted a new article with id: " + articleId);
        System.out.println("Its HASH looks like:");
        Map<String, String> articleData = redis.hgetAll("article:" + articleId);
        for (Map.Entry<String, String> entry : articleData.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }

        System.out.println();

        articleVote("other_user", "article:" + articleId);
        String votes = redis.hget("article:" + articleId, "votes");
        System.out.println("We voted for the article, it now has votes: " + votes);
        assert Integer.parseInt(votes) > 1;

        System.out.println("The currently highest-scoring articles are:");
        List<Map<String, String>> articles = getArticles(redis, 1);
        printArticles(articles);
        assert articles.size() >= 1;

        addGroups(redis, articleId, new String[]{"new-group"});
        System.out.println("We added the article to a new group, other articles include:");
        articles = getGroupArticles(redis, "new-group", 1);
        printArticles(articles);
        assert articles.size() >= 1;
        redis.close();
    }

    public String postArticle(Jedis redis, String user, String title, String link) {
        String articleId = String.valueOf(redis.incr("article:"));

        String voted = "voted:" + articleId;
        redis.sadd(voted, user);
        redis.expire(voted, ONE_WEEK_IN_SECONDS);

        long now = System.currentTimeMillis() / 1000;
        String article = "article:" + articleId;
        HashMap<String, String> articleData = new HashMap<String, String>();
        articleData.put("title", title);
        articleData.put("link", link);
        articleData.put("user", user);
        articleData.put("now", String.valueOf(now));
        articleData.put("votes", "1");
        redis.hmset(article, articleData);
        redis.zadd("score:", now + VOTE_SCORE, article);
        redis.zadd("time:", now, article);

        return articleId;
    }

    public void articleVote(String user, String article) {
        long cutoff = (System.currentTimeMillis() / 1000) - ONE_WEEK_IN_SECONDS;
        if (redis.zscore("time:", article) < cutoff) {
            return;
        }

        String articleId = article.substring(article.indexOf(':') + 1);
        if (redis.sadd("voted:" + articleId, user) == 1) {
            redis.zincrby("score:", VOTE_SCORE, article);
            redis.hincrBy(article, "votes", 1l);
        }
    }

    public List<Map<String, String>> getArticles(Jedis redis, int page) {
        return getArticles(redis, page, "score:");
    }

    public List<Map<String, String>> getArticles(Jedis redis, int page, String order) {
        int start = (page - 1) * ARTICLES_PER_PAGE;
        int end = start + ARTICLES_PER_PAGE - 1;

        Set<String> ids = redis.zrevrange(order, start, end);
        List<Map<String, String>> articles = new ArrayList<Map<String, String>>();
        for (String id : ids) {
            Map<String, String> articleData = redis.hgetAll(id);
            articleData.put("id", id);
            articles.add(articleData);
        }

        return articles;
    }

    public void addGroups(Jedis redis, String articleId, String[] toAdd) {
        String article = "article:" + articleId;
        for (String group : toAdd) {
            redis.sadd("group:" + group, article);
        }
    }

    public List<Map<String, String>> getGroupArticles(Jedis redis, String group, int page) {
        return getGroupArticles(redis, group, page, "score:");
    }

    public List<Map<String, String>> getGroupArticles(Jedis redis, String group, int page, String order) {
        String key = order + group;
        if (!redis.exists(key)) {
            ZParams params = new ZParams().aggregate(ZParams.Aggregate.MAX);
            redis.zinterstore(key, params, "group:" + group, order);
            redis.expire(key, 60);
        }
        return getArticles(redis, page, key);
    }

    private void printArticles(List<Map<String, String>> articles) {
        for (Map<String, String> article : articles) {
            System.out.println("  id: " + article.get("id"));
            for (Map.Entry<String, String> entry : article.entrySet()) {
                if (entry.getKey().equals("id")) {
                    continue;
                }
                System.out.println("    " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
