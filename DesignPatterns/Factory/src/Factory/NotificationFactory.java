package Factory;

public class NotificationFactory {
    public static Notification createNotification(String type){
        if (type.equals("SMS")) return new SmsNotification();
        else if (type.equals("EMAIL")) {
            return new EmailNotification();
        }
        throw  new IllegalArgumentException("Unknown Type");
    }
}
