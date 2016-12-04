package com.geek.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Liuqi
 * Date: 2016/11/23.
 */
public class ConnectionUtils {



    private static JedisPool pool;



    public static Jedis getJedisInstance() {
        if (pool == null) {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxWaitMillis(60);
            config.setFairness(true);
            //pool = new JedisPool(config, "127.0.0.1", 6379);
            pool = new JedisPool("127.0.0.1", 6379);
        }

        return pool.getResource();
    }


    public static Jedis getSimpleConnecton() {
        Jedis redis = new Jedis("127.0.0.1", 6379);
        /*redis.auth("geek2306");*/
        return redis;
    }
}
