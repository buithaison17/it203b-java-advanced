package xuatsac2;

public class PrintReceipt implements NotificationService {
    @Override
    public void sendNotify(String message) {
        System.out.println(message);
    }
}
