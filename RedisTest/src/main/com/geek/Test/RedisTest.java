package com.geek.Test;

import redis.clients.jedis.Jedis;

import java.util.UUID;

/**
 * Created by Liuqi
 * Date: 2016/11/25.
 */
public class RedisTest {
    public static final Integer MAXACTIVE_TIME = 60 * 30;
    public void cacheSession(Jedis jedis,String username){

    }

    /**
     * 缓存reuqest
     * @param jedis
     * @param request
     */
    public void cacheRequest(Jedis jedis, String request) {

        String token = UUID.randomUUID().toString();

        jedis.hset("request:", token, request);
    }

    public void cacheLoginCookie(Jedis jedis, String username) {
        String uuid = UUID.randomUUID().toString();
    }

    public void updateToken(Jedis redis, String token, String user) {
        long timestamp = System.currentTimeMillis() / 1000;
        redis.hset("login:", token, user);
    }

}
