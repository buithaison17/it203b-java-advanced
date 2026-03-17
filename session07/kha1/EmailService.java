package kha1;

public class EmailService {
    public void sendMail(String email, String orderId) {
        System.out.printf("Đã gửi email đến %s: Đơn hàng %s đã được tạo", email, orderId);
    }
}
