package temp;

import thread.ThreadPoolTest;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Nannf
 * @date 2021/7/1 9:18
 * @description
 */
public class TestThreadPool {

    public static void main(String[] args) {
        ThreadPoolTest threadPoolTest = new ThreadPoolTest(10, new ArrayBlockingQueue<>(3));

        for ( int i =0 ; i< 40;i++) {
            final int a = i;
            threadPoolTest.submit(() -> {
                System.out.println("hello Thread pool, i am " + a);
            });
        }
    }
}
