package xuatsac2;

public class POSFactory implements SalesChannelFactory {

    @Override
    public DiscountStrategy createDiscountStrategy() {
        return new MemberDiscount();
    }

    @Override
    public NotificationService createNotificationService() {
        return new PrintReceipt();
    }

    @Override
    public PaymentMethod createPaymentMethod() {
        return new CODPayment();
    }
}