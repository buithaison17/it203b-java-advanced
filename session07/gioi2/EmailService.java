package gioi2;

public class EmailService implements NotificationService {

    @Override
    public void send(String message, String recipient) {
        System.out.printf("Gửi SMS: %s\n", message);
    }
}
