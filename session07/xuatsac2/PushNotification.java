package xuatsac2;

import xuatsac1.notifications.NotificationService;

public class PushNotification implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Gửi push notification: " + message);
    }
}