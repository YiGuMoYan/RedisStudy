package top.yigumoyan.base;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class TestKey {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.59.129", 6379);

        System.out.println("清空数据：" + jedis.flushDB());
        System.out.println("判断某个键是否存在：" + jedis.exists("username"));
        System.out.println("添加 username zhangsan 键值对：" + jedis.set("username", "zhangsan"));
        System.out.println("添加 password password 键值对：" + jedis.set("password", "password"));
        System.out.println("系统中所有键值对如下：");
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
        System.out.println("删除键 password：" + jedis.del("password"));
        System.out.println("判断 password 是否存在：" + jedis.exists("password"));
        System.out.println("查看 username 的存储类型：" + jedis.type("username"));
        System.out.println("随机返回 key 空间的一个：" + jedis.randomKey());
        System.out.println("重命名 key：" + jedis.rename("username", "name"));
        System.out.println("取出改后的 name：" + jedis.get("name"));
        System.out.println("按索引查询：" + jedis.select(0));
        System.out.println("删除当前数据库中的所有 key：" + jedis.flushDB());
        System.out.println("返回当前数据库中所有 key 的数目：" + jedis.dbSize());
        System.out.println("删除所有数据库中的 key：" + jedis.flushAll());
    }
}
