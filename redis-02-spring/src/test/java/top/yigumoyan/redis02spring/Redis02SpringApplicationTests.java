package top.yigumoyan.redis02spring;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import top.yigumoyan.redis02spring.entity.pojo.User;
import top.yigumoyan.redis02spring.utils.RedisUtil;

@SpringBootTest
class Redis02SpringApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {

        // redisTemplate 操作不同的数据类型，api 和我们的指是一样的
        // opsForValue
        // opsForList
        // opsForSet
        // opsForHash
        // opsForZSet
        // opsForGeo
        // opsForHyperLogLog
        // redisTemplate.opsForHyperLogLog();


        // 除了基本的操作，我们常用的方法都可以通过 redisTemplate 操作
        // 比如事务，基础的 crud
        // 获取 redis 的连接对象
        // RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        // connection.flushDb();

        // redisTemplate.opsForValue().set("key", "value");
        // System.out.println(redisTemplate.opsForValue().get("key"));
    }

    @Test
    public void test() throws JsonProcessingException {
        User user = new User("张三", 18);
        // String jsonUser = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user", user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

    @Test
    public void test1() {
        redisUtil.set("user", "张三");
        System.out.println(redisUtil.get("user"));
    }

}
