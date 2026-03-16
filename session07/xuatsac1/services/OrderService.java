package xuatsac1.services;

import xuatsac1.discounts.DiscountStrategy;
import xuatsac1.models.Order;
import xuatsac1.notifications.NotificationService;
import xuatsac1.payments.PaymentMethod;
import xuatsac1.repositories.OrderRepository;

public class OrderService {
    private OrderRepository repository;
    private NotificationService notification;

    public OrderService(OrderRepository repository,
            NotificationService notification) {
        this.repository = repository;
        this.notification = notification;
    }

    public void createOrder(Order order,
            DiscountStrategy discount,
            PaymentMethod payment) {
        double total = order.getTotalAmount();
        double discountValue = discount.applyDiscount(total);
        double finalAmount = total - discountValue;
        payment.pay(finalAmount);
        repository.save(order);
        notification.send("Đơn hàng đã tạo");
    }
}
