package plus.extvos.redis.service;

import java.util.concurrent.TimeUnit;

/**
 * @author shenmc
 */
public interface RedisService {
    void set(String key, Object obj);

    void set(String key, Object obj, int expires);

    void set(String key, Object obj, int expires, TimeUnit unit);

    Object get(String key);
}
