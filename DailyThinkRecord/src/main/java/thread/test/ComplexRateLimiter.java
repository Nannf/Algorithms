package thread.test;

import java.util.concurrent.TimeUnit;

/**
 * @author Akmd Nannf
 * @version v1.0
 * @Description
 * @date 2021/7/9 14:16
 */
public class ComplexRateLimiter {
    // 令牌桶中可以被请求的令牌数
    private long storedPermits;

    // 令牌桶的容量
    private long maxPermits;

    // 下一个令牌的产生时间
    private long nextFreeTicketMicros;

    // 令牌的产生周期
    private long stableIntervalMicros = 1_000_000_000;


    //线程给定一个申请时间，返回线程需要等待的时间
    private synchronized long reserve(long now) {
        return 0L;
    }


    // 线程申请令牌
    public void acquire() throws InterruptedException {
        long now = System.nanoTime();

        long wait = reserve(now);

        // 必要时进行等待
        if (wait > 0) {
            TimeUnit.MICROSECONDS.sleep(wait);
        }

    }
}
