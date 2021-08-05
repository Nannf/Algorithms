package cache;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Akmd Nannf
 * @version v1.0
 * @Description
 * @date 2021/8/5 21:34
 */
public class CacheWithoutSync<K,V> {
    private ConcurrentHashMap<K,V> map = new ConcurrentHashMap<>();

    // 当同时调用时，假设我们的calu耗时较久，会计算两次
    // 此时我们就想到了异步计算框架FutureTask
    public V get(K k) {
        if (map.contains(k)) {
            return map.get(k);
        }
        V v = calu(k);
        map.put(k,v);
        return v;
    }

    private V calu(K k) {
        return null;
    }
}
