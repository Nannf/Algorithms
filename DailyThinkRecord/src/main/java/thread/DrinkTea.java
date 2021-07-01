package thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author Nannf
 * @date 2021/7/1 14:06
 * @description 烧水泡茶
 * 这个其实是多线程之间的分工与同步之间的关系
 * 涉及到多个线程的步调一致，一组线程互相等待，考虑使用 CyclicBarrier，
 * 有两个工作之间还有先后关系。但是这两个工作与另外的几个工作之间是可以并行的。
 */
public class DrinkTea {
    ExecutorService callBack = Executors.newSingleThreadExecutor();

    ExecutorService executorService = Executors.newFixedThreadPool(4);

    private final CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> {
        callBack.execute(() -> {
            System.out.println("所有的工作全部准备完毕，我要泡祁门红茶了！");
        });
    });

    public void process() {
        executorService.submit(() -> {
            try {
                System.out.println("我是洗茶壶程序，我要洗一秒钟");
                Thread.sleep(1000);
                System.out.println("我洗完茶壶了");
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                System.out.println("我是洗茶茶杯程序，我要洗两秒钟");
                Thread.sleep(2000);
                System.out.println("我洗完茶杯了");
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                System.out.println("我是拿茶叶程序，我要拿一秒钟");
                Thread.sleep(1000);
                System.out.println("我拿完茶叶了");
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            System.out.println("我是洗水壶程序，我要洗一秒钟");
            Thread.sleep(1000);
            System.out.println("我洗完水壶了");
            return 9527;
        });
        executorService.submit(futureTask);

        executorService.submit(() -> {
            try {
                System.out.println("洗水壶程序完成了，给我返回了" + futureTask.get());
                System.out.println("开始使用水壶烧开水，我要烧5秒钟");
                Thread.sleep(5000);
                System.out.println("水烧开了");
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    public static void main(String[] args) {
        new DrinkTea().process();
    }

}
