package plus.extvos.redis.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author shenmc
 */
public class QuickRedisTemplate extends RedisTemplate<String, Object> {
    public QuickRedisTemplate() {
        setHashKeySerializer(new StringRedisSerializer());
        setKeySerializer(new StringRedisSerializer());
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        setHashValueSerializer(new GenericJackson2JsonRedisSerializer(om));
        setValueSerializer(new GenericJackson2JsonRedisSerializer(om));
    }

    public QuickRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        this();
        setConnectionFactory(redisConnectionFactory);
        afterPropertiesSet();
    }
}
