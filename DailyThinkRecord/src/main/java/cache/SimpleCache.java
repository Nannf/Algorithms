package cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Akmd Nannf
 * @version v1.0
 * @Description
 * @date 2021/8/5 21:29
 */
public class SimpleCache<K, V> {
    private Map<K, V> map = new HashMap<>();

    // 这个的问题在于串行化
    public synchronized V get(K k) {
        if (map.containsKey(k)) {
            return map.get(k);
        }
        V v = calu(k);
        map.put(k, v);
        return v;
    }

    private V calu(K k) {
        return null;
    }
}
