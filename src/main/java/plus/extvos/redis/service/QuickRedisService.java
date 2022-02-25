package plus.extvos.redis.service;

import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author shenmc
 */
public interface QuickRedisService {
    /**
     *
     * @param key
     * @param value
     */
    void set(String key, Object value);

    /**
     *
     * @param key
     * @param value
     * @param expires
     */
    void set(String key, Object value, long expires);


    /**
     *
     * @param key
     * @param value
     * @param duration
     */
    void set(String key, Object value, Duration duration);

    /**
     *
     * @param key
     * @param value
     * @param expires
     * @param unit
     */
    void set(String key, Object value, long expires, TimeUnit unit);

    /**
     *
     * @param key
     * @return object by key
     */
    Object get(String key);

    /**
     *
     * @param key
     * @param value
     * @return object of key
     */
    Object getAndSet(String key, Object value);

    /**
     *
     * @param keys
     * @return objects with keys
     */
    List<Object> multiGet(Collection<String> keys);
}
