package plus.extvos.redis.service;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author shenmc
 */
public class QuickRedisTemplate extends RedisTemplate<String,Object> {
    public QuickRedisTemplate() {
        setHashKeySerializer(new StringRedisSerializer());
        setKeySerializer(new StringRedisSerializer());
        setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        setValueSerializer(new GenericJackson2JsonRedisSerializer());
    }

    public QuickRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        this();
        setConnectionFactory(redisConnectionFactory);
        afterPropertiesSet();
    }
}
