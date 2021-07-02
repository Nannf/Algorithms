package thread;

import java.util.concurrent.*;

/**
 * @author Nannf
 * @date 2021/7/2 13:42
 * @description
 */
public class CompletionServiceTest {

    public void before() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

        FutureTask<Integer> task1 = new FutureTask<>(
                () -> {
                    System.out.println("开始查询第一家厂商的数据，耗时2天");
                    sleep(2000);
                    System.out.println("查询第一家厂商的数据成功！");
                    return 234;
                }
        );

        FutureTask<Integer> task2 = new FutureTask<>(
                () -> {
                    System.out.println("开始查询第2家厂商的数据，耗时9天");
                    sleep(9000);
                    System.out.println("查询第2家厂商的数据成功！");
                    return 2534;
                }
        );

        FutureTask<Integer> task3 = new FutureTask<>(
                () -> {
                    System.out.println("开始查询第3家厂商的数据，耗时6天");
                    sleep(6000);
                    System.out.println("查询第3家厂商的数据成功！");
                    return 278;
                }
        );
        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);

        executorService.execute(() -> {
            try {
                queue.add(task1.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        executorService.execute(() -> {
            try {
                queue.add(task2.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        executorService.execute(() -> {
            try {
                queue.add(task3.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        for (int i = 0; i < 3; i++) {
            System.out.println(queue.take().intValue());
        }
    }

    public void after() {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);

        completionService.submit(() -> {
            System.out.println("开始查询第3家厂商的数据，耗时6天");
            sleep(6000);
            System.out.println("查询第3家厂商的数据成功！");
            return 278;
        });
        completionService.submit(() -> {
            System.out.println("开始查询第2家厂商的数据，耗时9天");
            sleep(9000);
            System.out.println("查询第2家厂商的数据成功！");
            return 2534;
        });
        completionService.submit(() -> {
            System.out.println("开始查询第一家厂商的数据，耗时2天");
            sleep(2000);
            System.out.println("查询第一家厂商的数据成功！");
            return 234;
        });

        for (int i = 0; i< 3;i++) {
            try {
                System.out.println(completionService.take().get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new CompletionServiceTest().after();
    }
}
