package Observer;

public class Channel {
    private java.util.List<String> subs = new java.util.ArrayList<>();
    public void subscribe(String name){
        subs.add(name);
    }

    public void uploadVideoNotification(String title){
        for (String sub:subs){
            System.out.println("Hey " + sub + ", new video uploaded: " + title);
        }
    }
}
