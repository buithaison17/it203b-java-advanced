package kha1;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private String id;
    private String customerId;
    private Map<Product, Integer> orderItems = new HashMap<>();
    private double totalPrice = 0;

    public Order(String id, String customerId) {
        this.id = id;
        this.customerId = customerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Map<Product, Integer> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Map<Product, Integer> orderItems) {
        this.orderItems = orderItems;
    }

    public void addOrderItem(Product product, int quantity) {
        if (orderItems.containsKey(product)) {
            orderItems.put(product, orderItems.get(product) + quantity);
        } else {
            orderItems.put(product, quantity);
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
