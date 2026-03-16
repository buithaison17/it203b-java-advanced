package xuatsac2;

import xuatsac1.discounts.DiscountStrategy;
import xuatsac1.discounts.PercentageDiscount;
import xuatsac1.notifications.NotificationService;
import xuatsac1.payments.Momo;
import xuatsac1.payments.PaymentMethod;

public class MobileFactory implements SalesChannelFactory {
    @Override
    public DiscountStrategy createDiscount() {
        return new PercentageDiscount(15);
    }

    @Override
    public PaymentMethod createPayment() {
        return new Momo();
    }

    @Override
    public NotificationService createNotification() {
        return new PushNotification();
    }
}