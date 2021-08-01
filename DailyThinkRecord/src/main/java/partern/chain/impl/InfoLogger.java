package partern.chain.impl;

import partern.chain.AbstractLogger;

/**
 * @author Akmd Nannf
 * @version v1.0
 * @Description
 * @date 2021/8/1 21:28
 */
public class InfoLogger extends AbstractLogger {


    public InfoLogger(int level) {
        this.level = level;
    }

    @Override
    public void write(String msg) {
        System.out.println("INFO : " + msg);
    }
}
