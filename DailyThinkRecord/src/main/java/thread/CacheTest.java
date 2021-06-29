package thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Nannf
 * @date 2021/6/29 18:45
 * @description
 */
public class CacheTest<K, V> {
    Map<K, V> cache = new HashMap<>();

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    ReentrantReadWriteLock.ReadLock readLock = lock.readLock();

    V get(K key) {
        V v = null;
        try {
            readLock.lock();

            v = cache.get(key);
        } finally {
            readLock.unlock();
        }
        // 缓存直接命中
        if (v != null) {
            return v;
        }

        writeLock.lock();

        try {
            v = cache.get(key);

            if ( v == null) {
                // 省略了从数据库中加载数据的代码
                // loadData
                v = null;
                cache.put(key,v);
            }
            return v;

        } finally {
            writeLock.unlock();
        }



    }

    void put(K key, V value) {
        try {
            writeLock.lock();
            cache.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }
}
