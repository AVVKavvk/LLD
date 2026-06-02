package COR;

public abstract class Logger {
    public static int INFO = 1;
    public static int ERROR = 2;
    protected int level;
    protected Logger nextLogger;

    public void setNextLogger(Logger logger){
        this.nextLogger = logger;
    }

    public void logMessage(int level, String message){
        if(this.level <=level) this.write(message);
        if (this.nextLogger!=null){
            this.nextLogger.logMessage(level,message);
        }
    }
    abstract protected void write(String message);
}
