package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author Nannf
 * @date 2021/7/1 14:37
 * @description 一个人做完的版本,
 * 这个人得先洗水壶，然后再用洗好的水壶烧开水，再等待水烧开的同时，我们依次洗茶杯，洗茶壶，拿茶叶，然后等水开，就可以泡茶了。
 * 这个是两个线程的处置过程，只有两条路都执行完成了，我们才能开始泡茶
 */
public class DrinkTeaOnePerson {

    ExecutorService executorService = Executors.newFixedThreadPool(2);

    public void process() {

        FutureTask<Integer> task1 = new FutureTask<>(() -> {
            System.out.println("我开始洗水壶，预计耗时1分钟");
            Thread.sleep(1000);
            System.out.println("我洗完水壶了，开始烧水，预计需要15分钟");
            Thread.sleep(15000);
            System.out.println("我水烧开了");
            return 9527;
        });
        executorService.submit(task1);

        FutureTask<String> task2 = new FutureTask<>(() -> {
            System.out.println("我开始洗茶壶，预计耗时1分钟");
            Thread.sleep(1000);
            System.out.println("我洗完茶壶了，开始洗茶杯，预计需要2分钟");
            Thread.sleep(2000);
            System.out.println("我洗完茶杯了，开始拿茶叶，预计耗时1分钟");
            Thread.sleep(1000);
            System.out.println("我拿完茶叶了");
            return "白毫银针";
        });
        executorService.submit(task2);

        try {
            System.out.println("烧水壶水烧开之后，发出了" +
                    task1.get() + "的声响，我们拿出了" +
                    task2.get() + "泡了一杯茶，并喝了个爽");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new DrinkTeaOnePerson().process();
    }
}
