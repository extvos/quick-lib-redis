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
     * set a key-value
     * @param key string
     * @param value object
     */
    void set(String key, Object value);

    /**
     * set a key-value with expires
     * @param key string
     * @param value object
     * @param expires in seconds
     */
    void set(String key, Object value, long expires);


    /**
     * set a key-value with expires
     * @param key string
     * @param value object
     * @param duration as expires
     */
    void set(String key, Object value, Duration duration);

    /**
     * set key-value with expires and unit
     * @param key string
     * @param value object
     * @param expires expires as long
     * @param unit time unit for expires
     */
    void set(String key, Object value, long expires, TimeUnit unit);

    /**
     * get value via key
     * @param key string
     * @return object by key
     */
    Object get(String key);

    /**
     * get and set key-value
     * @param key string
     * @param value object
     * @return object of key
     */
    Object getAndSet(String key, Object value);

    /**
     * get multiple keys
     * @param keys in collection
     * @return objects with keys
     */
    List<Object> multiGet(Collection<String> keys);
}
