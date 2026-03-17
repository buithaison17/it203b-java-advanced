package xuatsac2;

public class EmailNotification implements NotificationService {
    @Override
    public void sendNotify(String message) {
        System.out.println(message);
    }
}
