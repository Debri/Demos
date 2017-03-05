package com.geek.util;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.UUID;

/**
 * Created by Liuqi
 * Date: 2016/11/24.
 */
public class ConnectionUtilsTest {

    @Test
    public void testGetJedisInstance() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            Thread t = new Thread(new Runnable() {
                public void run() {
                    System.out.println("+++++++++++");
                    Jedis redis = ConnectionUtils.getJedisInstance();
                    UUID id = UUID.randomUUID();
                    redis.set("liuqi", String.valueOf("liuqi"));
                    System.out.println("-------------" + redis.get(String.valueOf(id)));
                }
            });
            t.start();
        }
    }

}