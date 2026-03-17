package xuatsac2;

import xuatsac1.discounts.DiscountStrategy;
import xuatsac1.discounts.PercentageDiscount;
import xuatsac1.notifications.EmailNotification;
import xuatsac1.notifications.NotificationService;
import xuatsac1.payments.CreditCard;
import xuatsac1.payments.PaymentMethod;

public class WebsiteFactory implements SalesChannelFactory {
    @Override
    public DiscountStrategy createDiscount() {
        return new PercentageDiscount(10);
    }

    @Override
    public PaymentMethod createPayment() {
        return new CreditCard();
    }

    @Override
    public NotificationService createNotification() {
        return new EmailNotification();
    }
}