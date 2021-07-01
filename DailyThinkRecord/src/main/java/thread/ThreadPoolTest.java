package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Nannf
 * @date 2021/7/1 8:58
 * @description
 */
public class ThreadPoolTest {
    // 阻塞队列，满了之后不在响应提交，与之相关的是拒绝策略
    private ArrayBlockingQueue<Runnable> queue;
    // 最多有多少个线程在执行任务
    private int poolSize;
    // 这个是真正工作的线程
    private List<WorkThread> workThreads = new ArrayList<>();

    // 构造函数
    public ThreadPoolTest(int poolSize, ArrayBlockingQueue<Runnable> queue) {
        this.poolSize = poolSize;
        this.queue = queue;
        for (int i = 0; i< poolSize;i++) {
            WorkThread workThread = new WorkThread();
            workThreads.add(workThread);
            workThread.start();
        }
    }


    private  class WorkThread extends Thread {
        @Override
        public void run() {
            // 每个线程的任务就是从阻塞队列中获取Runnable对象去执行
            while(true) {
                try {
                    Runnable runnable = queue.take();
                    runnable.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public void submit(Runnable runnable) {
        try {
            queue.put(runnable);
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }
}
