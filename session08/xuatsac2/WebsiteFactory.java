package xuatsac2;

public class WebsiteFactory implements SalesChannelFactory {

    @Override
    public NotificationService createNotificationService() {
        return new EmailNotification();
    }

    @Override
    public DiscountStrategy createDiscountStrategy() {
        return new WebsiteDiscount();
    }

    @Override
    public PaymentMethod createPaymentMethod() {
        return new CreditCardPayment();
    }

}
