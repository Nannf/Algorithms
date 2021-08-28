package exam;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 编写一个程序来反应商店对某件商品的进货与销售过程，并将相关信息并打印出来,具体要求如下：
//1、进货与销售过程各新建一个线程；
//2、当商品数目少于10时进货,进货数目随机生成但不少于50；
//3、销售数目随机生成,数目不大于商品数量；
//4、二次销售之间的时间随机生成,但不大于2s。
public class AnswerForExam5 {
    private static final Lock lock = new ReentrantLock();
    private static final Condition produceCondition = lock.newCondition();
    private static final Condition consumeCondition = lock.newCondition();
    private static final Random random = new Random(9527);
    private static int goodsNumber = 0;

    static class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("当前线程被中断");
                    break;
                }
                lock.lock();
                try {
                    if (goodsNumber >= 10) {
                        try {
                            System.out.println("当前的货物数量是" + goodsNumber + "无需进货");
                            produceCondition.await();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            System.out.println(e);
                        }
                    } else {
                        int numbers = random.nextInt(20) + 50;
                        System.out.println("当前的货物数量是" + goodsNumber + "，开始进货,本次进到货物" + numbers);
                        goodsNumber += numbers;
                        consumeCondition.signalAll();
                    }
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    static class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("当前线程被中断");
                    break;
                }
                lock.lock();
                try {
                    if (goodsNumber <= 0) {
                        try {
                            System.out.println("当前的货物数量是" + goodsNumber + "没有办法销售");
                            produceCondition.signalAll();
                            consumeCondition.await();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            System.out.println(e);
                        }
                    } else {
                        int numbers = random.nextInt(Math.max(1,goodsNumber - 1)) + 1;
                        System.out.println("当前的货物数量是" + goodsNumber + "，开始销售,本次销售了" + numbers);
                        goodsNumber -= numbers;
                        long sleepSeconds = random.nextInt(2000);
                        try {
                            System.out.println("本次销售结束，休息:"+sleepSeconds+"ms");
                            Thread.sleep(sleepSeconds);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            System.out.println(e);
                        }
                    }
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        Producer producer = new Producer();
        consumer.start();
        producer.start();
    }

}
