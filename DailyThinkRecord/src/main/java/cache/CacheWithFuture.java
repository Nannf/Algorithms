package cache;

import java.util.concurrent.*;

/**
 * @author Akmd Nannf
 * @version v1.0
 * @Description
 * @date 2021/8/5 21:41
 */
public class CacheWithFuture<K, V> {
    private ConcurrentHashMap<K, Future<V>> map = new ConcurrentHashMap<>();

    // 当同时调用时，假设我们的calu耗时较久，会计算两次
    // 此时我们就想到了异步计算框架FutureTask
    public V get(K k) throws InterruptedException {
        Future<V> v = map.get(k);
        // 如果不存在
        if (v == null) {
            Callable<V> callable = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return null;
                }
            };
            FutureTask<V> ft = new FutureTask<>(callable);
            v = map.putIfAbsent(k,ft);
            // 表示没有别的线程往里面写
            if (v == null) {
                v = ft;
                // 先计算
                ft.run();
            }
        }

        try {
            return v.get();
        } catch (CancellationException e) {
            // 如果计算被终止了，那么缓存中应该移除
            map.remove(k,v);
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

}
