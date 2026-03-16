package xuatsac2;

import xuatsac1.discounts.*;
import xuatsac1.payments.*;
import xuatsac1.notifications.*;

public interface SalesChannelFactory {
    DiscountStrategy createDiscount();

    PaymentMethod createPayment();

    NotificationService createNotification();
}
