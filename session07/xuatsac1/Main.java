package xuatsac1;

import xuatsac1.models.*;
import xuatsac1.discounts.*;
import xuatsac1.repositories.*;
import xuatsac1.payments.*;
import xuatsac1.notifications.*;
import xuatsac1.services.*;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Product> products = new ArrayList<>();
    static List<Customer> customers = new ArrayList<>();
    static List<Order> orders = new ArrayList<>();
    static Map<Integer, PaymentMethod> payments = new HashMap<>();
    static Map<Integer, DiscountStrategy> discounts = new HashMap<>();

    public static void main(String[] args) {
        // Payment mặc định
        payments.put(1, new CODPayment());
        payments.put(2, new CreditCard());
        payments.put(3, new Momo());
        payments.put(4, new VNPay());

        // Discount mặc định
        discounts.put(1, new PercentageDiscount(10));
        discounts.put(2, new FixedDiscount(50000));
        discounts.put(3, new HolidayDiscount());

        OrderRepository repo = new FileOrderRepository();
        NotificationService notify = new EmailNotification();
        OrderService service = new OrderService(repo, notify);

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Thêm khách hàng");
            System.out.println("3. Tạo đơn hàng");
            System.out.println("4. Xem danh sách đơn hàng");
            System.out.println("5. Tính tổng doanh thu");
            System.out.println("6. Thêm phương thức thanh toán mới");
            System.out.println("7. Thêm chiến lược giảm giá mới");
            System.out.println("0. Thoát");
            int choice = scanner.nextInt();
            switch (choice) {

                case 1:
                    addProduct();
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    createOrder(service);
                    break;
                case 4:
                    showOrders();
                    break;
                case 5:
                    revenue();
                    break;
                case 6:
                    addPayment();
                    break;
                case 7:
                    addDiscount();
                    break;
                case 0:
                    System.out.println("Thoát chương trình");
                    return;
            }
        }
    }

    // Thêm sản phẩm
    static void addProduct() {
        scanner.nextLine();
        System.out.print("Mã: ");
        String id = scanner.nextLine();
        System.out.print("Tên: ");
        String name = scanner.nextLine();
        System.out.print("Giá: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Danh mục: ");
        String category = scanner.nextLine();
        Product p = new Product(id, name, price, category);
        products.add(p);
        System.out.println("Đã thêm sản phẩm " + id);
    }

    // 2. THÊM KHÁCH HÀNG
    static void addCustomer() {
        scanner.nextLine();
        System.out.print("Tên: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("ĐT: ");
        String phone = scanner.nextLine();
        Customer c = new Customer(name, email, phone);
        customers.add(c);
        System.out.println("Đã thêm khách hàng");
    }

    // 3. TẠO ĐƠN HÀNG
    static void createOrder(OrderService service) {
        if (products.isEmpty() || customers.isEmpty()) {
            System.out.println("Cần có sản phẩm và khách hàng trước");
            return;
        }
        System.out.println("Chọn khách:");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println(i + ". " + customers.get(i).getFullName());
        }
        int cIndex = scanner.nextInt();
        Customer customer = customers.get(cIndex);
        System.out.println("Chọn sản phẩm:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(i + ". " + products.get(i).getProductName());
        }
        int pIndex = scanner.nextInt();
        System.out.print("Số lượng: ");
        int quantity = scanner.nextInt();
        Product product = products.get(pIndex);
        OrderItem item = new OrderItem(product, quantity);
        List<OrderItem> items = new ArrayList<>();
        items.add(item);
        String orderId = "ORD" + (orders.size() + 1);
        Order order = new Order(orderId, customer, items);
        System.out.println("Chọn giảm giá:");
        discounts.forEach((k, v) -> System.out.println(k + ". " + v.getClass().getSimpleName()));
        int dChoice = scanner.nextInt();
        DiscountStrategy discount = discounts.get(dChoice);
        System.out.println("Chọn thanh toán:");
        payments.forEach((k, v) -> System.out.println(k + ". " + v.getClass().getSimpleName()));
        int pChoice = scanner.nextInt();
        PaymentMethod payment = payments.get(pChoice);
        service.createOrder(order, discount, payment);
        orders.add(order);
    }

    // 4. DANH SÁCH ĐƠN HÀNG
    static void showOrders() {
        System.out.println("Danh sách đơn hàng:");
        for (Order o : orders) {
            System.out.println(
                    o.getOrderId() + " - " +
                            o.getCustomer().getFullName() + " - " +
                            o.getTotalAmount());
        }
    }

    // 5. DOANH THU
    static void revenue() {
        double total = 0;
        for (Order o : orders) {
            total += o.getTotalAmount();
        }
        System.out.println("Tổng doanh thu: " + total);
    }

    // 6. THÊM PAYMENT
    static void addPayment() {
        scanner.nextLine();
        System.out.print("Tên phương thức: ");
        String name = scanner.nextLine();
        payments.put(payments.size() + 1,
                amount -> System.out.println("Thanh toán qua " + name));

        System.out.println("Đã thêm phương thức thanh toán " + name);
    }

    // 7. THÊM DISCOUNT
    static void addDiscount() {
        System.out.print("Nhập % giảm: ");
        double percent = scanner.nextDouble();
        discounts.put(discounts.size() + 1,
                amount -> amount * percent / 100);

        System.out.println("Đã thêm chiến lược giảm giá " + percent + "%");
    }
}