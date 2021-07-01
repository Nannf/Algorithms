package thread;

import java.util.concurrent.CompletableFuture;

/**
 * @author Nannf
 * @date 2021/7/1 22:19
 * @description
 */
public class CompletableFutureTest {

    public void process() {
        CompletableFuture<Void> c1 = CompletableFuture.runAsync(() -> {
            System.out.println("我开始洗水壶，预计耗时1分钟");
            sleep(1000);
            System.out.println("我洗完水壶了，开始烧水，预计需要15分钟");
            sleep(15000);
            System.out.println("我水烧开了");
        });

        CompletableFuture<String> c2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("我开始洗茶壶，预计耗时1分钟");
            sleep(1000);
            System.out.println("我洗完茶壶了，开始洗茶杯，预计需要2分钟");
            sleep(2000);
            System.out.println("我洗完茶杯了，开始拿茶叶，预计耗时1分钟");
            sleep(1000);
            System.out.println("我拿完茶叶了");
            return "白毫银针";
        });

        CompletableFuture<String> c3 = c1.thenCombine(c2,(__,tf) -> {
            System.out.println("拿到茶叶"+tf);
            System.out.println("开始泡茶");
            return "上茶"+tf;
        });
        System.out.println(c3.join());
    }

    public static void main(String[] args) {
        new CompletableFutureTest().process();
    }

    public void sleep(long mills) {
        try {
          Thread.sleep(mills);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
