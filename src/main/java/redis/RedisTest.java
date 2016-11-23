package redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Liuqi
 * Date: 2016/11/23.
 */
public class RedisTest {
    private Jedis jedis;

    public RedisTest() {
        jedis = new Jedis("127.0.0.1", 6379);
        //jedis.auth("master");
    }

    @Test
    public void testString() {
        jedis.set("name", "liuqi");
        jedis.del("name");
        System.out.println(jedis.get("name"));
    }

    @Test
    public void testMap() {
        /*Map<String, String> map = new HashMap<String, String>();
        map.put("name", "liuqi");
        map.put("age", "20");
        map.put("email", "18908356464@163.com");
        jedis.hmset("user", map);*/
        System.out.println(jedis.hmget("user", "name", "age"));
        System.out.println(jedis.hgetAll("user"));
    }

    @Test
    public void testList() {
        List<String> list = new ArrayList<String>();
        list.add("liuqi");
        list.add("haode ");
        jedis.lpush("list", "liuqi", "haode");
        System.out.println(jedis.lrange("list", 0, -1));
    }

    @Test
    public void testSet() {
        System.out.println(jedis.sadd("liuqi1", "haode", "keyi  ", "haode"));

        System.out.println(jedis.smembers("liuqi1"));
    }

    @Test
    public void testZset() {
        Map<String, Double> map = new HashMap<String, Double>();
        map.put("liuqi", 1.0);
        map.put("liuqi1", 2.0);
        map.put("liuqi", 2.0);
        System.out.println(jedis.zadd("nihao", map));
        System.out.println(jedis.zrange("nihao", 0, -1));
    }
}
