package gioi2;

public class Gioi2 {
    public static void main(String[] args) {
        // OrderRepository repository = new FileOrderRepository();
        // NotificationService notification = new EmailService();
        // OrderService orderService = new OrderService(repository, notification);
        // orderService.createOrder("ORD001", "customer@gmail.com");
        OrderRepository repository = new DatabaseOrderRepository();
        NotificationService notification = new SMSNotification();
        OrderService orderService = new OrderService(repository, notification);
        orderService.createOrder("ORD002", "0123456789");
    }
}
