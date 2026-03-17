package xuatsac2;

public class MobileAppFactory implements SalesChannelFactory {

    @Override
    public NotificationService createNotificationService() {
        return new PushNotification();
    }

    @Override
    public DiscountStrategy createDiscountStrategy() {
        return new FirstTimeDiscount();
    }

    @Override
    public PaymentMethod createPaymentMethod() {
        return new MomoPayment();
    }

}
