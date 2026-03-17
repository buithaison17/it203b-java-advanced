package xuatsac1.notifications;

public class SMSNotification implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Đã gửi SMS");
    }
}
