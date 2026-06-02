import Factory.Notification;
import Factory.NotificationFactory;

void main() {

    Notification smsNotification = NotificationFactory.createNotification("SMS");
    smsNotification.notifyUser();
    Notification emailNotification = NotificationFactory.createNotification("EMAIL");
    emailNotification.notifyUser();

}