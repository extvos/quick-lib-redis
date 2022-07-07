package plus.extvos.redis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plus.extvos.redis.service.QuickRedisService;
import plus.extvos.redis.service.QuickRedisTemplate;

import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author shenmc
 */
@Service
public class QuickRedisServiceImpl implements QuickRedisService {

    @Autowired
    QuickRedisTemplate redisTemplate;

    @Override
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void set(String key, Object value, long expires) {
        redisTemplate.opsForValue().set(key, value, expires);
    }

    @Override
    public void set(String key, Object value, Duration duration) {
        redisTemplate.opsForValue().set(key, value, duration);
    }

    @Override
    public void set(String key, Object value, long expires, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, expires, unit);
    }

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public Boolean delete(String key) {
        return redisTemplate.delete(key);
    }

    @Override
    public Object getAndSet(String key, Object value) {
        return redisTemplate.opsForValue().getAndSet(key, value);
    }

    @Override
    public List<Object> multiGet(Collection<String> keys) {
        return redisTemplate.opsForValue().multiGet(keys);
    }

    @Override
    public Collection<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }
}
