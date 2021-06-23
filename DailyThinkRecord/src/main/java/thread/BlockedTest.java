package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Nannf
 * @date 2021/6/23 15:31
 * @description 本代码的目标时检测是不是只有synchronized框起来的线程才是BLOCKED
 */
public class BlockedTest {

    private final static ReentrantLock lock = new ReentrantLock();


    public static void main(String[] args) {
        new Thread(() -> lockTest(),"nn").start();
        new Thread(()->lockTest2(),"ff").start();
    }



    public static void lockTest2() {
        try {
            lock.lock();
            Thread.sleep(100000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public static void lockTest() {
        try {
            lock.lock();
            Thread.sleep(100000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
            finally {
            lock.unlock();
        }
    }


}
