package thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Nannf
 * @date 2021/7/3 17:56
 * @description
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "-" + ThreadId.get());
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "-" + ThreadId.get());
            }
        });

        t1.start();
        t2.start();
        System.out.println(t1.getName());
        System.out.println(t2.getName());
    }

    static class ThreadId {
        static final AtomicInteger at = new AtomicInteger(1);

        static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> {
            return at.getAndIncrement();
        });

        static int get() {
            return threadLocal.get();
        }
    }
}
