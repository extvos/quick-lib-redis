package plus.extvos.redis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plus.extvos.redis.service.QuickRedisService;
import plus.extvos.redis.service.QuickRedisTemplate;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

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
        redisTemplate.opsForValue().set(key, value, expires, TimeUnit.SECONDS);
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

    @Override
    public Object hget(String key, String field) {
        return redisTemplate.opsForHash().get(key, field);
    }

    @Override
    public void hdelete(String key, String... fields) {
        redisTemplate.opsForHash().delete(key, fields);
    }

    @Override
    public Set<String> hkeys(String key) {
        return redisTemplate.opsForHash().keys(key).stream().map(Object::toString).collect(Collectors.toSet());
    }

    @Override
    public Map<String, Object> hgetall(String key) {
        Map<String, Object> m = new HashMap<>();
        redisTemplate.opsForHash().entries(key).forEach((k, v) -> {
            m.put(k.toString(), v);
        });
        return m;
    }

    @Override
    public void hmset(String key, String field, Object value) {
        redisTemplate.opsForHash().put(key, field, value);
    }

    @Override
    public void hsetall(String key, Map<String, Object> vals) {
        redisTemplate.opsForHash().putAll(key, vals);
    }
}
