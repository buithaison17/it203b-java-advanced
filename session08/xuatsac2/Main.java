package xuatsac2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SalesChannelFactory factory = null;
        int choice;
        do {
            System.out.println("-----Chon kenh-----");
            System.out.println("1. Website");
            System.out.println("2. Mobile");
            System.out.println("3. POS");
            System.out.println("4. Thoat");
            System.out.print("Nhap kenh: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    factory = new WebsiteFactory();
                    break;
                case 2:
                    factory = new MobileAppFactory();
                    break;
                case 3:
                    factory = new POSFactory();
                    break;
                case 4:
                    System.out.println("Thoat");
                    break;
                default:
                    System.out.println("Chuc nang khong hop le");
                    break;
            }
            break;
        } while (choice != 4);

        if (factory == null) {
            sc.close();
            return;
        }

        OrderService order = new OrderService(factory);
        System.out.print("Nhap gia: ");
        double price = sc.nextDouble();
        System.out.print("Nhap so luong: ");
        int quantity = sc.nextInt();
        order.processOrder(price, quantity);
        sc.close();
    }
}
