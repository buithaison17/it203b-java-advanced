package xuatsac1.repositories;

import java.util.ArrayList;
import java.util.List;

import xuatsac1.models.Order;

public class FileOrderRepository implements OrderRepository {
    private List<Order> orders = new ArrayList<>();

    @Override
    public void save(Order order) {
        orders.add(order);
        System.out.println("Đã lưu đơn hàng " + order.getOrderId());
    }

    @Override
    public List<Order> findAll() {
        return orders;
    }
}
