package thread.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class MyRateLimiterTest {
    static ExecutorService executorService = Executors.newFixedThreadPool(20);

    public static void main(String[] args) {
        MyRateLimiter myRateLimiter = new MyRateLimiter(10);

        myRateLimiter.createToken();

        executorService.execute(() ->{
            while (true) {
                if (myRateLimiter.acquireToken() != null) {
                    System.out.println("i get token");
                } else {
                    System.out.println("i am not ");
                }
                try {
                    // 定时往队列里加
                    TimeUnit.MILLISECONDS.sleep(100);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}