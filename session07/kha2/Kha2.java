package kha2;

import kha1.*;

public class Kha2 {
    public static void main(String[] args) {
        // Tạo dữ liệu mẫu
        CustomerRepository customerRepository = new CustomerRepository();
        ProductRepository productRepository = new ProductRepository();
        OrderRepository orderRepository = new OrderRepository();
        EmailService emailService = new EmailService();
        OrderCalculatorKha2 orderCalculator = new OrderCalculatorKha2(new NoDiscount(), orderRepository);

        // Tạo các mã giả giá
        DiscountStrategy noDiscount = new NoDiscount();
        DiscountStrategy percentageDiscount = new PercentageDiscount(0.1);
        DiscountStrategy holidayDiscount = new HolidayDiscount();

        // Tạo dữ liệu
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
        double price = orderCalculator.calculateTotalPrice("ODER001", holidayDiscount);
        System.out.println("\nTổng tền: " + price);
        price = orderCalculator.calculateTotalPrice("ODER001", noDiscount);
        System.out.println("\nTổng tền: " + price);
    }
}