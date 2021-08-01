package partern.chain;

/**
 * @author Akmd Nannf
 * @version v1.0
 * @Description
 * @date 2021/8/1 21:24
 */
public abstract class AbstractLogger {

    // 指向下一个处置的节点
    protected  AbstractLogger nextAbstractLogger;

    protected void addLast(AbstractLogger nextAbstractLogger) {
        this.nextAbstractLogger = nextAbstractLogger;
    }

    private AbstractLogger next() {
        return nextAbstractLogger;
    }


    // 打印消息
    public abstract void printMessage(int level, String msg);
}
