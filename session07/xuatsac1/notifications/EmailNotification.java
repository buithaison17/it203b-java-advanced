package xuatsac1.notifications;

public class EmailNotification implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Đã gửi email xác nhận");
    }
}
