package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Nannf
 * @date 2021/7/1 11:22
 * @description
 */
public class SubmitTest {

    public static void main(String[] args) throws Exception{
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("hello callable");
                return "nannf";
            }
        };
        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Future<String> future = executorService.submit(callable);
//        System.out.println(future.get());
        Future<?> future = executorService.submit(() ->{
            try {
                Thread.sleep(3000);
                System.out.println("i am submit runnable!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        while (!future.isDone()) {
            System.out.println("i am not done");
            Thread.sleep(1000);
        }
        System.out.println("i am done");
        System.out.println(future.get());

    }
}
