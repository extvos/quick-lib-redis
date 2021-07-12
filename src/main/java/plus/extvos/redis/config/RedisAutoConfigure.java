package plus.extvos.redis.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import plus.extvos.redis.service.QuickRedisTemplate;

import java.net.UnknownHostException;

/**
 * @author shenmc
 */
@ConditionalOnProperty(prefix = "spring.redis", name = "enabled", havingValue = "true", matchIfMissing = true)
@ComponentScan("plus.extvos.redis")
@Configuration
public class RedisAutoConfigure {

    @Bean
    @ConditionalOnMissingBean(QuickRedisTemplate.class)
    public QuickRedisTemplate quickRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        return new QuickRedisTemplate(redisConnectionFactory);
    }
}
