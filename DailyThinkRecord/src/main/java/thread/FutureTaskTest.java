package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author Nannf
 * @date 2021/7/1 11:44
 * @description
 */
public class FutureTaskTest {


    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newSingleThreadExecutor();

//        FutureTask<Integer> futureTask = new FutureTask<>(()->{
//            return 1+1;
//        });
//        executorService.submit(futureTask);
//        System.out.println(futureTask.get());

//        Result result = new Result();
//        result.setName("kkk");
//        FutureTask<Result> future = new FutureTask<>(new Task(result),result);
//        executorService.submit(future);
//        System.out.println(future.get().getName());
        FutureTask<Integer> futureTask = new FutureTask<>(()->{
            return 9527;
        });
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }

    static class Result {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class Task implements Runnable {
        private Result result;

        public Task(Result result) {
            this.result = result;
        }

        @Override
        public void run() {
            result.setName("nannf");
            System.out.println("start task！");
        }
    }
}
