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
    private Condition waitFullCondition = lock.newCondition();
    private Condition waitEmptyCondition = lock.newCondition();
    private static final int MAX_SIZE = 10;


    public E get() {
        try {
            lock.lock();
            while (data.isEmpty()) {
                waitFullCondition.await();
            }
            E e = data.getFirst();
            waitEmptyCondition.notifyAll();
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
            if (data == null) {
                LinkedList<E> linkedList = new LinkedList<>();
                linkedList.add(e);
                return;
            }
            while (data.size() ==  MAX_SIZE) {
                waitEmptyCondition.await();
            }
            data.add(e);
            waitFullCondition.notifyAll();
        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
