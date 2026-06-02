package Signleton;

public class Database {

    private static volatile Database instance = null;  // volatile for thread-safety

    private Database(){
        System.out.println("Connecting to database...");
    }

    public static Database getInstance(){
        if(instance==null){
            instance = new Database();
        }
        return instance;
    }
    public void query(String sql) {
        System.out.println("Executing: " + sql);
    }
}
