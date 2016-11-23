package com.geek.util;

import redis.clients.jedis.Jedis;

/**
 * Created by Liuqi
 * Date: 2016/11/23.
 */
public class ConnectionUtils {
    private static Jedis redis;

/*    static {
        redis = new Jedis("127.0.0.1", 6379);
    }*/
    public static Jedis getSimpleConnecton(){
        redis=new Jedis("127.0.0.1", 6379);
        return redis;
    }
}
