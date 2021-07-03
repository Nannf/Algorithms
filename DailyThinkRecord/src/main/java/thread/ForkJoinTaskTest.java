package thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author Nannf
 * @date 2021/7/3 14:44
 * @description
 */
public class ForkJoinTaskTest {

    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool(4);

        Fibonacci fibonacci = new Fibonacci(4);
        Integer result = fjp.invoke(fibonacci);
        System.out.println(result);

    }

    static class Fibonacci extends RecursiveTask<Integer> {
        int n;
        Fibonacci(int n ){
            this.n =n;
        }
        @Override
        protected Integer compute() {
            if (n <= 1) {
                return n;
            }
            Fibonacci f1 = new Fibonacci(n -1);
            // 创建子任务
            f1.fork();
            Fibonacci f2 = new Fibonacci(n -2);
            return f2.compute() + f1.join();
        }
    }
}
