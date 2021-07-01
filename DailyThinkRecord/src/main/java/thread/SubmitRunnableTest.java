package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Nannf
 * @date 2021/7/1 11:32
 * @description
 */
public class SubmitRunnableTest {


    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Result result = new Result();
        result.setName("kkk");
        Future<Result> future = executorService.submit(new Task(result),result);
        System.out.println(future.get().getName());
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
