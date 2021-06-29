package thread;

import java.util.concurrent.locks.StampedLock;

/**
 * @author Nannf
 * @date 2021/6/29 21:20
 * @description
 */
public class StampedLockTest {
    private double x, y;
    static final StampedLock lock = new StampedLock();

    public void test() {
        // 乐观读
        long stamp = lock.tryOptimisticRead();
        // 把成员变量赋值给局部变量，因为是乐观读，我们在读的时候
        // 可能会有线程修改了这两个变量
        double curX = x;
        double curY = y;

        // 为了保证如果我们在读取的期间有别的线程写了，
        // lock.validate 返回false
        if (!lock.validate(stamp)) {
            // 悲观读
            stamp = lock.readLock();

            try {
                curX = x;
                curY = y;
            } finally {
                lock.unlockRead(stamp);
            }
        }
    }

    final StampedLock sl = new StampedLock();

    // 存在问题的方法
    void moveIfAtOrigin(double newX, double newY) {
        long stamp = sl.readLock();
        try {
            while (x == 0.0 && y == 0.0) {
                long ws = sl.tryConvertToWriteLock(stamp);
                if (ws != 0L) {
                    // stamp = ws;
                    x = newX;
                    y = newY;
                    break;
                } else {
                    sl.unlockRead(stamp);
                    stamp = sl.writeLock();
                }
            }
        } finally {
            sl.unlock(stamp);
        }
    }

    public static void main(String[] args) {
        new StampedLockTest().moveIfAtOrigin(1.2,2.3);
    }

}
