package xuatsac2;

import xuatsac1.discounts.DiscountStrategy;
import xuatsac1.discounts.FixedDiscount;
import xuatsac1.notifications.NotificationService;
import xuatsac1.payments.CODPayment;
import xuatsac1.payments.PaymentMethod;

public class POSFactory implements SalesChannelFactory {
    @Override
    public DiscountStrategy createDiscount() {
        return new FixedDiscount(50000);
    }

    @Override
    public PaymentMethod createPayment() {
        return new CODPayment();
    }

    @Override
    public NotificationService createNotification() {
        return new PrintInvoiceNotification();
    }
}
