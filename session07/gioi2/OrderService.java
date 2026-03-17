package gioi2;

public class OrderService {

    private OrderRepository orderRepository;
    private NotificationService notificationService;

    public OrderService(OrderRepository orderRepository,
            NotificationService notificationService) {
        this.orderRepository = orderRepository;
        this.notificationService = notificationService;
    }

    public void createOrder(String orderId, String customer) {
        Order order = new Order(orderId);
        orderRepository.save(order);
        notificationService.send(
                "Đơn hàng " + orderId + " đã được tạo",
                customer);
    }
}