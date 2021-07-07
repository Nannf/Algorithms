package thread.test;

import java.util.concurrent.TimeUnit;

/**
 * @author Nannf
 * @date 2021/7/7 14:06
 * @description
 * 简单限流器，简单的含义是
 * - 令牌的产生时间固定，为一秒一个
 * - 令牌桶大小固定，为一个
 * - 用时间表示令牌的产生时间
 * - 当线程获取令牌的时间在下一个令牌的产生之前，会让线程等待两者之间的差值，并更新令牌的产生时间
 * - 当线程获取令牌的时间在令牌的时间之后，线程会立马执行，下一个令牌的时间是获取时间+一秒
 *
 *
 */
public class SimpleRateLimiter {
    // 下一个令牌的产生时间
    private long next = System.nanoTime();
    // 令牌的生成周期，单位ns
    private long interval = 1_000_000_000;


    // 线程请求令牌的时候会传请求的时间过来
    // 方法返回的是当前线程获取到令牌需要等待的时间
    synchronized long reserve(long now) {
        // 如果下一个令牌的产生时间在申请时间之后
        if (next - now >= 0) {
            // 表示线程需要等待这两个的差值，
            // 因为这个令牌已经被当前线程获取，所以我们需要更新下一个令牌的产生时间
            long wait = next - now;
            // 下一个令牌的产生时间为当前的值加上产生周期
            next = next + interval;
            return wait;
        } else {
            // 如果令牌在第4s产生，线程到第七秒才来获取，那么线程应该无需等待，并更新令牌产生时间
            next = next + interval;
            return 0L;
        }
    }


    public void acquire() {
        long wait = reserve(System.nanoTime());

        if (wait > 0) {
            try {
                TimeUnit.NANOSECONDS.sleep(wait);
                // 业务代码
            }catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        } else {
            // 业务代码。
        }
    }

}
