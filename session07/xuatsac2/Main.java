package xuatsac2;

import java.util.Scanner;

import xuatsac1.discounts.DiscountStrategy;
import xuatsac1.notifications.NotificationService;
import xuatsac1.payments.PaymentMethod;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chọn kênh bán:");
        System.out.println("1. Website");
        System.out.println("2. Mobile App");
        System.out.println("3. POS");
        int choice = scanner.nextInt();
        SalesChannelFactory factory = null;
        switch (choice) {

            case 1:
                factory = new WebsiteFactory();
                System.out.println("Bạn đã chọn kênh Website");
                break;
            case 2:
                factory = new MobileFactory();
                System.out.println("Bạn đã chọn kênh Mobile App");
                break;
            case 3:
                factory = new POSFactory();
                System.out.println("Bạn đã chọn kênh POS");
                break;
        }
        DiscountStrategy discount = factory.createDiscount();
        PaymentMethod payment = factory.createPayment();
        NotificationService notify = factory.createNotification();
        double price = 15000000;
        double discountValue = discount.applyDiscount(price);
        double finalAmount = price - discountValue;
        payment.pay(finalAmount);
        notify.send("Đơn hàng thành công");
        scanner.close();
    }
}