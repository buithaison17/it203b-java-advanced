package gioi2;

import java.util.ArrayList;
import java.util.List;

public class DatabaseOrderRepository implements OrderRepository {
    List<Order> orders = new ArrayList<>();

    @Override
    public List<Order> findAll() {
        return orders;
    }

    @Override
    public void save(Order order) {
        orders.add(order);
        System.out.printf("Lưu đơn hàng %s thành công\n", order.getId());
    }

}
