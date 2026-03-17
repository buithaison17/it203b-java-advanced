package xuatsac2;

public class OrderService {
    private DiscountStrategy discountStrategy;
    private PaymentMethod paymentMethod;
    private NotificationService notificationService;

    public OrderService(SalesChannelFactory factory) {
        this.discountStrategy = factory.createDiscountStrategy();
        this.paymentMethod = factory.createPaymentMethod();
        this.notificationService = factory.createNotificationService();
    }

    public void processOrder(double price, int quantity) {
        double totalAmount = price * quantity;
        double discountAmount = discountStrategy.applyDiscount(totalAmount);
        double finalAmount = totalAmount - discountAmount;
        System.out.println("Giam gia: " + discountAmount);
        System.out.println("Thanh tien: " + finalAmount);
        paymentMethod.pay(finalAmount);
        notificationService.sendNotify("Tao don hang thanh cong");
    }

    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

}
