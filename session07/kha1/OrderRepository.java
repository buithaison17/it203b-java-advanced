package kha1;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private List<Order> orders = new ArrayList<>();

    public List<Order> getAll() {
        return orders;
    }

    public Order findById(String id) {
        return orders.stream().filter(o -> o.getId().equals(id)).findFirst().orElse(null);
    }

    public void save(Order order) {
        orders.add(order);
    }
}
