package xuatsac2;

public interface SalesChannelFactory {
    DiscountStrategy createDiscountStrategy();

    PaymentMethod createPaymentMethod();

    NotificationService createNotificationService();
}
