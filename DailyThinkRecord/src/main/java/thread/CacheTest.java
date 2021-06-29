package thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Nannf
 * @date 2021/6/29 18:45
 * @description
 */
public class CacheTest<K,V> {
    Map<K,V> cache = new HashMap<>();

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    ReentrantReadWriteLock.ReadLock readLock = lock.readLock();

    V get(K key) {
        try {
            readLock.lock();
            return cache.get(key);
        }finally {
            readLock.unlock();
        }
    }

    void put(K key, V value) {
        try {
            writeLock.lock();
            cache.put(key,value);
        }finally {
            writeLock.unlock();
        }
    }
}
