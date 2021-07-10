package thread.test;

import java.util.concurrent.TimeUnit;

/**
 * @author Akmd Nannf
 * @version v1.0
 * @Description
 * @date 2021/7/9 14:16
 */
public class ComplexRateLimiter {
    // 令牌桶中可以被请求的令牌数
    private long storedPermits;

    // 令牌桶的容量
    private long maxPermits;

    // 下一个令牌的产生时间
    private long nextFreeTicketMicros;

    // 令牌的产生周期
    private long stableIntervalMicros = 1_000_000_000;


    //线程给定一个申请时间，返回线程需要等待的时间
    private synchronized long reserve(long now) {
        reSync(now);

        return 0L;
    }

    // 相较于之间的SimpleRateLimiter新增了这个方法，
    // 这个方法存在的目的我目前的感觉就是和参数定义的可用令牌数的更新和下一个令牌的产生时间有关
    private void reSync(long now) {
        // 我们在SRL中对线程申请令牌的时间进行了不同的处理
        // 之所以这样是因为两者之间关于下一个令牌的产生时间的更新是不同的。
        // 当我们有令牌桶之后，情况会有所改变吗？
        // 这其中有一个问题，就是令牌桶如何进行初始化呢？就是令牌桶中的令牌在一开始是满的还是空的
        // 因为我们没有一个令牌对象的概念，只是用时间来模拟了令牌，假设我们是在时间点A生成的限流器对象
        // 线程从时间点B开始调用限流器的获取令牌方法，在最开始的状态，这显然不可能，我们肯定是先有这个限流器对象，才能供别的线程使用
        // 所以限流器对象的一开始的下一个令牌的产生时间，一定 happens-before 后续的申请工作。
        // 所以第一个申请的对象，一定在限流器对象生成之后，如果是之后的话，我们就可以模拟初始化放令牌的动作
        // 通过申请时间和创建时间的差值，以及生成令牌的周期，和令牌桶的最大容量比较，获取其中的最小值
        if (now >  nextFreeTicketMicros) {
            // 每一个申请令牌的线程在申请的时候，我们都通过这种方式重新计算令牌桶种的令牌数量
            storedPermits = Math.min(maxPermits,(now - nextFreeTicketMicros) / stableIntervalMicros);
            nextFreeTicketMicros = now;
        }
        // 在这里我们开始思考，令牌桶大于1之后，对我们申请程序而言，意味着什么
        // 如果我申请的时间在下一个令牌的产生之前，此时又当如何处理

    }


    // 线程申请令牌
    public void acquire() throws InterruptedException {
        long now = System.nanoTime();
        long wait = reserve(now);
        // 必要时进行等待
        if (wait > 0) {
            TimeUnit.MICROSECONDS.sleep(wait);
        }
    }
}
