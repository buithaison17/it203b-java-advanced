package kha2;

import kha1.Order;
import kha1.OrderRepository;

public class OrderCalculatorKha2 {
    DiscountStrategy discountStrategy;
    OrderRepository orderRepository;

    public OrderCalculatorKha2(DiscountStrategy discountStrategy, OrderRepository orderRepository) {
        this.discountStrategy = discountStrategy;
        this.orderRepository = orderRepository;
    }

    public double calculateTotalPrice(String id, DiscountStrategy discount) {
        Order order = orderRepository.findById(id);
        if (order == null) {
            return 0;
        }
        double price = order.getOrderItems().entrySet().stream().mapToDouble(e -> e.getValue() * e.getKey().getPrice()).sum();
        return discount.applyDiscount(price);
    }

}