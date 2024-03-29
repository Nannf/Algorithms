package thread.concurrency.cancel;

import java.util.concurrent.*;

public class CancellingExecutor extends ThreadPoolExecutor {
    public CancellingExecutor(BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(10, 10, 1, TimeUnit.MINUTES, workQueue, threadFactory, handler);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        if (callable instanceof CancellableTask) {
            return ((CancellableTask<T>) callable).newTask();
        }else {
            return super.newTaskFor(callable);
        }
    }
}
