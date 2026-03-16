package xuatsac1.repositories;

import java.util.List;

import xuatsac1.models.Order;

public interface OrderRepository {
    void save(Order order);

    List<Order> findAll();
}
