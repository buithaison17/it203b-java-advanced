package kha1;

public class OrderCalculator {
    private OrderRepository orderRepository;

    public OrderCalculator(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public double CalculateTotalPrice(String id) {
        Order order = orderRepository.findById(id);
        if (order == null) {
            return 0;
        }
        return order.getOrderItems().entrySet().stream().mapToDouble(e -> e.getValue() * e.getKey().getPrice()).sum();
    }
}
