package thread.test;


import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Nannf
 * @date 2021/7/6 10:17
 * @description
 */
public class RateLimiterTest {

    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(2.0d);
        ExecutorService es = Executors.newFixedThreadPool(1);

        final long[] prevT = {System.nanoTime()};

        for (int i = 0; i < 20; i++) {
            rateLimiter.acquire();
            es.execute(() -> {
                long cur = System.nanoTime();
                System.out.println((cur- prevT[0])/1000_000);
                prevT[0] = cur;
            });
        }

    }
}
