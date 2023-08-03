package top.yigumoyan.ping;

import redis.clients.jedis.Jedis;

public class TestPing {

    public static void main(String[] args) {
        // new Jedis 对象
        Jedis jedis = new Jedis("192.168.59.129", 6379);

        System.out.println(jedis.ping());
    }
}
