package xuatsac2;

import xuatsac1.notifications.NotificationService;

public class PrintInvoiceNotification implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("In hóa đơn giấy: " + message);
    }
}
