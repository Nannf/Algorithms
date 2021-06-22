package thread;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Nannf
 * @date 2021/6/22 16:58
 * @description
 */
public class SimpleBlockingQueue<E> {
    private LinkedList<E> data;
    private final ReentrantLock lock = new ReentrantLock();
    private Condition waitSpaceToAddCondition = lock.newCondition();
    private Condition waitDataToGetCondition = lock.newCondition();
    private static final int MAX_SIZE = 10;


    public E get() {
        try {
            lock.lock();
            // 当是空的时候
            while (data.isEmpty()) {
                waitDataToGetCondition.await();
            }
            E e = data.getFirst();
            // 取完之后，就可以唤醒所有在等着空间加数据的线程了
            waitSpaceToAddCondition.notifyAll();
            return e;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    public void set(E e) {
        try {
            lock.lock();
            // 第一次执行的时候
            if (data == null) {
                LinkedList<E> linkedList = new LinkedList<>();
                linkedList.add(e);
                return;
            }
            // 队列满了
            while (data.size() ==  MAX_SIZE) {
                waitSpaceToAddCondition.await();
            }
            data.add(e);
            waitDataToGetCondition.notifyAll();
        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
