package kha1;

public class Kha1 {
    public static void main(String[] args) {
        // Khởi tạo các dịch vụ
        CustomerRepository customerRepository = new CustomerRepository();
        ProductRepository productRepository = new ProductRepository();
        OrderRepository orderRepository = new OrderRepository();
        EmailService emailService = new EmailService();
        OrderCalculator orderCalculator = new OrderCalculator(orderRepository);

        // Tạo dữ liệu mẫu
        Customer customer = new Customer("c001", "Nguyễn Văn A", "Việt Nam", "a@example.com");
        customerRepository.addCustomer(customer);
        Product product1 = new Product("sp001", "Laptop", 15000000);
        productRepository.addProduct(product1);
        Product product2 = new Product("sp002", "Chuột", 300000);
        productRepository.addProduct(product2);
        Order order = new Order("ODER001", "c001");
        order.addOrderItem(product1, 1);
        order.addOrderItem(product2, 2);
        orderRepository.save(order);
        emailService.sendMail(customer.getEmail(), order.getId());
        double price = orderCalculator.CalculateTotalPrice("ODER001");
        System.out.println("\nTổng tền: " + price);
    }
}
