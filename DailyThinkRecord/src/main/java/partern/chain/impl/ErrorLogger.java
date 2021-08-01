package partern.chain.impl;

import partern.chain.AbstractLogger;

/**
 * @author Akmd Nannf
 * @version v1.0
 * @Description
 * @date 2021/8/1 21:28
 */
public class ErrorLogger extends AbstractLogger {

    private int level;

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    public void printMessage(int level,String msg) {
        if (this.level >= level) {
            System.out.println("ERROR : " + msg);
        }

        if (nextAbstractLogger != null) {
            nextAbstractLogger.printMessage(level,msg);
        }
    }
}
