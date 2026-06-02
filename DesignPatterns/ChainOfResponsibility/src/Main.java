import COR.ErrorLogger;
import COR.InfoLogger;
import COR.Logger;

void main() {
    Logger loggerChain = new InfoLogger(Logger.INFO);
    Logger errorLogger = new ErrorLogger(Logger.ERROR);

    loggerChain.setNextLogger(errorLogger);

    loggerChain.logMessage(Logger.INFO, "System started.");
    loggerChain.logMessage(Logger.ERROR, "System crashed!");
}