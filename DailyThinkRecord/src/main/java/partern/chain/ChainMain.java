package partern.chain;

import partern.chain.impl.ErrorLogger;
import partern.chain.impl.InfoLogger;
import partern.chain.impl.WarnLogger;

/**
 * @author Akmd Nannf
 * @version v1.0
 * @Description
 * @date 2021/8/1 21:33
 */
public class ChainMain {

    public static void main(String[] args) {
        InfoLogger infoLogger = new InfoLogger(LoggerLevel.INFO_LEVEL);
        WarnLogger warnLogger = new WarnLogger(LoggerLevel.WARN_LEVEL);
        ErrorLogger errorLogger = new ErrorLogger(LoggerLevel.ERROR_LEVEL);
        infoLogger.nextAbstractLogger = warnLogger;
        warnLogger.nextAbstractLogger = errorLogger;

        infoLogger.printMessage(LoggerLevel.ERROR_LEVEL,"error");
        infoLogger.printMessage(LoggerLevel.WARN_LEVEL,"warn");
        infoLogger.printMessage(LoggerLevel.INFO_LEVEL,"info");

    }
}
