package thread.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Nannf
 * @date 2021/7/6 20:35
 * @description 先自己实现令牌桶算法。
 * 这个算法的目的是为了限流。
 * - 我们如何定义令牌，需要一个专门的令牌对象吗，这个令牌对象需要有哪些属性，提供哪些方法呢
 * - 如何生成令牌，令牌可以放在阻塞队列里
 * - 如何限制令牌上限，当阻塞队列满了之后，我们变不在放
 * - 如何控制速率，我们定时的往阻塞队列里加
 * - 如何校验令牌，如何判断这个令牌对象是我生成的呢？
 */
public class MyRateLimiter {
    // 最大容量
    private int burst;

    // 我们需要一个阻塞队列
    private ArrayBlockingQueue<Token> queue;

    ExecutorService executorService = Executors.newSingleThreadExecutor();

    private volatile boolean isTerminal;

    public MyRateLimiter(int burst) {
        this.burst = burst;
        queue = new ArrayBlockingQueue<>(burst);
    }


    // 获取token的方案
    public Token acquireToken() {
        // 如果获取不到，返回null
        return queue.poll();
    }

    // 生产令牌
    public void createToken() {
        executorService.execute(() -> {
            while (!isTerminal && !Thread.currentThread().isInterrupted()) {
                try {
                    if (queue.size() == burst) {
                        System.out.println("i am full");
                    } else {
                        queue.add(new Token());
                    }
                    // 定时往队列里加
                    TimeUnit.MILLISECONDS.sleep(1000L * burst / 60);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

    }

    public void stop() {
        isTerminal = true;
    }


    // 令牌，但是我们发现这个令牌无法定义任何的属性和方法
    // 因为令牌只是一个逻辑上的概念，表示请求方需要获取到这个东西
    // 二是，如果令牌真的对应一个真实的对象，那么我们会产生很多朝生夕死的对象，这会增加系统的GC压力
    // 所以，关于令牌，新建对象可能不是一个好方法
    public static final class Token {

    }

}
