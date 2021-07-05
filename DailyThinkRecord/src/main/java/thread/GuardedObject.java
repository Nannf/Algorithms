package thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

/**
 * @author Nannf
 * @date 2021/7/5 13:44
 * @description
 */
public class GuardedObject<T> {

    // 受保护对象
    private T t;

    private Lock lock = new ReentrantLock();

    private Condition notNullCondition = lock.newCondition();

    // 这个是等待的人和等待的资源之间的映射关系
    private static final Map<Object,GuardedObject> map = new ConcurrentHashMap<>();

    static <K> GuardedObject create(K key) {
        GuardedObject go = new GuardedObject();
        map.put(key,go);
        return go;
    }

    static <K,T> void fireEvent(K key, T value) {
        GuardedObject go = map.remove(key);
        if (go != null) {
            go.onChange(value);
        }
    }


    T get(Predicate<T> p) {
        try {
            lock.lock();
            while (!p.test(t)) {
                notNullCondition.await();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    void onChange(T t) {
        lock.lock();
        try {
            this.t = t;
            notNullCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
