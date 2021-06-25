package thread;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 * @author Nannf
 * @date 2021/6/24 17:17
 * @description
 * 信号量测试。
 * 测试的目的主要是完成信号量的基本使用
 *
 * 一个计数器，一个等待队列，三个操作方法down up init
 */
public class SemaphoreTest {
    // 允许的并行线程数
    private int permits;
    // 等待队列
    private Queue queue;
    // 构造函数
    public SemaphoreTest(int permits) {
        this.permits = permits;
        queue = new ArrayDeque();
    }

    public void down() {
        try {
            permits--;
            // 如果小于0了，表示没有获取到，我们需要把当前的线程加入阻塞队列
            if (permits < 0) {
                queue.add(Thread.currentThread());
            } else {
                // doSomething...
            }
        } finally {

        }
    }

    public void up() {
        permits++;
        if (permits<=0) {
            // 从阻塞队列中获取一个正在等待的队列
        }
    }




}
