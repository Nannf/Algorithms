package partern.chain.impl;

import partern.chain.AbstractLogger;

/**
 * @author Akmd Nannf
 * @version v1.0
 * @Description
 * @date 2021/8/1 21:28
 */
public class InfoLogger extends AbstractLogger {

    private int level;

    public InfoLogger(int level) {
        this.level = level;
    }

    @Override
    public void printMessage(int level,String msg) {
        if (this.level >= level) {
            System.out.println("INFO : " + msg);
        }
        if (nextAbstractLogger != null) {
            nextAbstractLogger.printMessage(level,msg);
        }
    }
}
