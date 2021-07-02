package thread;

import java.util.concurrent.CompletableFuture;

/**
 * @author Nannf
 * @date 2021/7/2 10:50
 * @description
 */
public class CompletionStageTest {

    public void thenApplyTest() {
        CompletableFuture<String> c = CompletableFuture.supplyAsync(
                () -> "Hello CompletionStage").
                thenApply(s -> s + " i am nannf").
                thenApply(String::toUpperCase);
        System.out.println(c.join());
    }

    public void thenCombineTest() {
        CompletableFuture<String> c = CompletableFuture.supplyAsync(() -> "hello");
        CompletableFuture<String> d = c.thenCombine(
                CompletableFuture.supplyAsync(() -> "completion stage"),(s1,s2)->
                    s1 + " " + s2
        );
        System.out.println(d.join());
    }

    public void runApplyEither() {
        CompletableFuture<String> c1 = CompletableFuture.supplyAsync(
                () -> {
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    return "Hello CompletionStage,i am nannf";
                });


        CompletableFuture<String> c2 = CompletableFuture.supplyAsync(
                () -> {
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    return "Hello CompletionStage,i am kiki";
                });

        CompletableFuture<String> c3 = c1.applyToEither(c2, s -> s);

        System.out.println(c3.join());
    }

    public void acceptTest() {
        CompletableFuture<String> c1 = CompletableFuture.supplyAsync(
                () ->"hello");
        c1.thenAccept(System.out::println);
    }

    public void exceptionTest() {
        CompletableFuture<Integer>
                f0 = CompletableFuture.supplyAsync(
                () -> (7 / 0))
                .thenApply(r -> r * 10).
                        exceptionally(e -> 0);
        System.out.println(f0.join());
    }

    public void exceptionHandleTest() {
        CompletableFuture<Integer>
                f0 = CompletableFuture.supplyAsync(
                () -> (7 / 0))
                .thenApply(r -> r * 10).
                        handle((s, t) -> {
                            if (t != null) {
                                System.out.println(t);
                                return 9527;
                            } else {
                                return s;
                            }
                        });
        System.out.println(f0.join());
    }

    public void exceptionWhenTest() {
        CompletableFuture<Integer>
                f0 = CompletableFuture.supplyAsync(
                () -> (7 / 0))
                .thenApply(r -> r * 10).
                        whenComplete((s, t) -> {
                            if (t != null) {
                                System.out.println(t);
                            }
                        });
        System.out.println(f0.join());
    }

    public void test(){
        CompletableFuture<Boolean> cf =
                CompletableFuture.supplyAsync(()->{
                    //在数据库中查询规则
                    return "9527";
                }).thenApply(r -> {
                    //规则校验
                   if (r.equalsIgnoreCase("9527")) {
                       return true;
                   }
                   return false;
                });
        System.out.println(cf.join());
    }

    public static void main(String[] args) {
        new CompletionStageTest().acceptTest();
    }
}
