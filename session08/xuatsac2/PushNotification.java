package xuatsac2;

public class PushNotification implements NotificationService {
    @Override
    public void sendNotify(String message) {
        System.out.println(message);
    }
}
