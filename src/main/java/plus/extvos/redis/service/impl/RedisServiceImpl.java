package plus.extvos.redis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import plus.extvos.redis.service.RedisService;

import java.util.concurrent.TimeUnit;

/**
 * @author shenmc
 */
public class RedisServiceImpl implements RedisService {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @Override
    public void set(String key, Object obj) {

    }

    @Override
    public void set(String key, Object obj, int expires) {

    }

    @Override
    public void set(String key, Object obj, int expires, TimeUnit unit) {

    }

    @Override
    public Object get(String key) {
        return null;
    }
}
