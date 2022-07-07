package plus.extvos.redis.service;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author shenmc
 */
public class QuickRedisTemplate extends RedisTemplate<String, Object> {
    public QuickRedisTemplate() {
        setHashKeySerializer(new StringRedisSerializer());
        setKeySerializer(new StringRedisSerializer());
//        ObjectMapper om = new ObjectMapper();
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
//        om.activateDefaultTyping(om.getPolymorphicTypeValidator());
//        GenericJackson2JsonRedisSerializer.registerNullValueSerializer(om, null);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
//        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        om.enableDefaultTyping();
//        GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();
//        setHashValueSerializer(new GenericJackson2JsonRedisSerializer(om));
//        setValueSerializer(new GenericJackson2JsonRedisSerializer(om));
    }

    public QuickRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        this();
        setConnectionFactory(redisConnectionFactory);
        afterPropertiesSet();
    }
}
