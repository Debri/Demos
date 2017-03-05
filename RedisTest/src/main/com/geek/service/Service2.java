package com.geek.service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Liuqi
 * Date: 2016/11/25.
 */
public class Service2 {
    public static final void main(String[] args)
            throws InterruptedException {
        new Service2().run();
    }

    public void run()
            throws InterruptedException {
        Jedis redis = new Jedis("localhost");
        redis.select(15);

        testLoginCookies(redis);
        testShopppingCartCookies(redis);
        testCacheRows(redis);
        testCacheRequest(redis);
    }

    public void testLoginCookies(Jedis redis)
            throws InterruptedException {
        System.out.println("\n----- testLoginCookies -----");
        String token = UUID.randomUUID().toString();

        updateToken(redis, token, "username", "itemX");
        System.out.println("We just logged-in/updated token: " + token);
        System.out.println("For user: 'username'");
        System.out.println();

        System.out.println("What username do we get when we look-up that token?");
        String r = checkToken(redis, token);
        System.out.println(r);
        System.out.println();
        assert r != null;

        System.out.println("Let's drop the maximum number of cookies to 0 to clean them out");
        System.out.println("We will start a thread to do the cleaning, while we stop it later");

        CleanSessionsThread thread = new CleanSessionsThread(0);
        thread.start();
        Thread.sleep(1000);
        thread.quit();
        Thread.sleep(2000);
        if (thread.isAlive()) {
            throw new RuntimeException("The clean sessions thread is still alive?!?");
        }

        long s = redis.hlen("login:");
        System.out.println("The current number of sessions still available is: " + s);
        assert s == 0;
    }

    public void testShopppingCartCookies(Jedis redis)
            throws InterruptedException {
        System.out.println("\n----- testShopppingCartCookies -----");
        String token = UUID.randomUUID().toString();

        System.out.println("We'll refresh our session...");
        updateToken(redis, token, "username", "itemX");
        System.out.println("And add an item to the shopping cart");
        addToCart(redis, token, "itemY", 3);
        Map<String, String> r = redis.hgetAll("cart:" + token);
        System.out.println("Our shopping cart currently has:");
        for (Map.Entry<String, String> entry : r.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();

        assert r.size() >= 1;

        System.out.println("Let's clean out our sessions and carts");
        CleanFullSessionsThread thread = new CleanFullSessionsThread(0);
        thread.start();
        Thread.sleep(1000);
        thread.quit();
        Thread.sleep(2000);
        if (thread.isAlive()) {
            throw new RuntimeException("The clean sessions thread is still alive?!?");
        }

        r = redis.hgetAll("cart:" + token);
        System.out.println("Our shopping cart now contains:");
        for (Map.Entry<String, String> entry : r.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
        assert r.size() == 0;
    }

    public void testCacheRows(Jedis redis)
            throws InterruptedException {
        System.out.println("\n----- testCacheRows -----");
        System.out.println("First, let's schedule caching of itemX every 5 seconds");
        scheduleRowCache(redis, "itemX", 5);
        System.out.println("Our schedule looks like:");
        Set<Tuple> s = redis.zrangeWithScores("schedule:", 0, -1);
        for (Tuple tuple : s) {
            System.out.println("  " + tuple.getElement() + ", " + tuple.getScore());
        }
        assert s.size() != 0;

        System.out.println("We'll start a caching thread that will cache the data...");

        CacheRowsThread thread = new CacheRowsThread();
        thread.start();

        Thread.sleep(1000);
        System.out.println("Our cached data looks like:");
        String r = redis.get("inv:itemX");
        System.out.println(r);
        assert r != null;
        System.out.println();

        System.out.println("We'll check again in 5 seconds...");
        Thread.sleep(5000);
        System.out.println("Notice that the data has changed...");
        String r2 = redis.get("inv:itemX");
        System.out.println(r2);
        System.out.println();
        assert r2 != null;
        assert !r.equals(r2);

        System.out.println("Let's force un-caching");
        scheduleRowCache(redis, "itemX", -1);
        Thread.sleep(1000);
        r = redis.get("inv:itemX");
        System.out.println("The cache was cleared? " + (r == null));
        assert r == null;

        thread.quit();
        Thread.sleep(2000);
        if (thread.isAlive()) {
            throw new RuntimeException("The database caching thread is still alive?!?");
        }
    }

    public void testCacheRequest(Jedis redis) {
        System.out.println("\n----- testCacheRequest -----");
        String token = UUID.randomUUID().toString();

        Callback callback = new Callback() {
            public String call(String request) {
                return "content for " + request;
            }
        };

        updateToken(redis, token, "username", "itemX");
        String url = "http://test.com/?item=itemX";
        System.out.println("We are going to cache a simple request against " + url);
        String result = cacheRequest(redis, url, callback);
        System.out.println("We got initial content:\n" + result);
        System.out.println();

        assert result != null;

        System.out.println("To test that we've cached the request, we'll pass a bad callback");
        String result2 = cacheRequest(redis, url, null);
        System.out.println("We ended up getting the same response!\n" + result2);

        assert result.equals(result2);

        assert !canCache(redis, "http://test.com/");
        assert !canCache(redis, "http://test.com/?item=itemX&_=1234536");
    }

    public String checkToken(Jedis redis, String token) {
        return redis.hget("login:", token);
    }

    public void updateToken(Jedis redis, String token, String user, String item) {
        long timestamp = System.currentTimeMillis() / 1000;
        redis.hset("login:", token, user);
        redis.zadd("recent:", timestamp, token);
        if (item != null) {
            redis.zadd("viewed:" + token, timestamp, item);
            redis.zremrangeByRank("viewed:" + token, 0, -26);
            redis.zincrby("viewed:", -1, item);
        }
    }

    public void addToCart(Jedis redis, String session, String item, int count) {
        if (count <= 0) {
            redis.hdel("cart:" + session, item);
        } else {
            redis.hset("cart:" + session, item, String.valueOf(count));
        }
    }

    public void scheduleRowCache(Jedis redis, String rowId, int delay) {
        redis.zadd("delay:", delay, rowId);
        redis.zadd("schedule:", System.currentTimeMillis() / 1000, rowId);
    }

    public String cacheRequest(Jedis redis, String request, Callback callback) {
        if (!canCache(redis, request)) {
            return callback != null ? callback.call(request) : null;
        }

        String pageKey = "cache:" + hashRequest(request);
        String content = redis.get(pageKey);

        if (content == null && callback != null) {
            content = callback.call(request);
            redis.setex(pageKey, 300, content);
        }

        return content;
    }

    public boolean canCache(Jedis redis, String request) {
        try {
            URL url = new URL(request);
            HashMap<String, String> params = new HashMap<String, String>();
            if (url.getQuery() != null) {
                for (String param : url.getQuery().split("&")) {
                    String[] pair = param.split("=", 2);
                    params.put(pair[0], pair.length == 2 ? pair[1] : null);
                }
            }

            String itemId = extractItemId(params);
            if (itemId == null || isDynamic(params)) {
                return false;
            }
            Long rank = redis.zrank("viewed:", itemId);
            return rank != null && rank < 10000;
        } catch (MalformedURLException mue) {
            return false;
        }
    }

    public boolean isDynamic(Map<String, String> params) {
        return params.containsKey("_");
    }

    public String extractItemId(Map<String, String> params) {
        return params.get("item");
    }

    public String hashRequest(String request) {
        return String.valueOf(request.hashCode());
    }

    public interface Callback {
        public String call(String request);
    }

    public class CleanSessionsThread
            extends Thread {
        private Jedis redis;
        private int limit;
        private boolean quit;

        public CleanSessionsThread(int limit) {
            this.redis = new Jedis("localhost");
            this.redis.select(15);
            this.limit = limit;
        }

        public void quit() {
            quit = true;
        }

        public void run() {
            while (!quit) {
                long size = redis.zcard("recent:");
                if (size <= limit) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                    }
                    continue;
                }

                long endIndex = Math.min(size - limit, 100);
                Set<String> tokenSet = redis.zrange("recent:", 0, endIndex - 1);
                String[] tokens = tokenSet.toArray(new String[tokenSet.size()]);

                ArrayList<String> sessionKeys = new ArrayList<String>();
                for (String token : tokens) {
                    sessionKeys.add("viewed:" + token);
                }

                redis.del(sessionKeys.toArray(new String[sessionKeys.size()]));
                redis.hdel("login:", tokens);
                redis.zrem("recent:", tokens);
            }
        }
    }

    public class CleanFullSessionsThread
            extends Thread {
        private Jedis redis;
        private int limit;
        private boolean quit;

        public CleanFullSessionsThread(int limit) {
            this.redis = new Jedis("localhost");
            this.redis.select(15);
            this.limit = limit;
        }

        public void quit() {
            quit = true;
        }

        public void run() {
            while (!quit) {
                long size = redis.zcard("recent:");
                if (size <= limit) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                    }
                    continue;
                }

                long endIndex = Math.min(size - limit, 100);
                Set<String> sessionSet = redis.zrange("recent:", 0, endIndex - 1);
                String[] sessions = sessionSet.toArray(new String[sessionSet.size()]);

                ArrayList<String> sessionKeys = new ArrayList<String>();
                for (String sess : sessions) {
                    sessionKeys.add("viewed:" + sess);
                    sessionKeys.add("cart:" + sess);
                }

                redis.del(sessionKeys.toArray(new String[sessionKeys.size()]));
                redis.hdel("login:", sessions);
                redis.zrem("recent:", sessions);
            }
        }
    }

    public class CacheRowsThread
            extends Thread {
        private Jedis redis;
        private boolean quit;

        public CacheRowsThread() {
            this.redis = new Jedis("localhost");
            this.redis.select(15);
        }

        public void quit() {
            quit = true;
        }

       /* public void run() {
            Gson gson = new Gson();
            while (!quit) {
                Set<Tuple> range = redis.zrangeWithScores("schedule:", 0, 0);
                Tuple next = range.size() > 0 ? range.iterator().next() : null;
                long now = System.currentTimeMillis() / 1000;
                if (next == null || next.getScore() > now) {
                    try {
                        sleep(50);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                    }
                    continue;
                }

                String rowId = next.getElement();
                double delay = redis.zscore("delay:", rowId);
                if (delay <= 0) {
                    redis.zrem("delay:", rowId);
                    redis.zrem("schedule:", rowId);
                    redis.del("inv:" + rowId);
                    continue;
                }

                Inventory row = Inventory.get(rowId);
                redis.zadd("schedule:", now + delay, rowId);
                redis.set("inv:" + rowId, gson.toJson(row));
            }
        }
    }
*/
   /* public static class Inventory {
        private String id;
        private String data;
        private long time;

        private Inventory(String id) {
            this.id = id;
            this.data = "data to cache...";
            this.time = System.currentTimeMillis() / 1000;
        }

        public static Inventory get(String id) {
            return new Inventory(id);
        }
    }*/
    }
}
