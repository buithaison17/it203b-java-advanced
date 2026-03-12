package services;

import models.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class ProductService {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public void displayAll() {
        if (isEmpty()) {
            System.out.println("Danh sách sản phẩm trống");
            return;
        }
        products.forEach(System.out::println);
    }

    public Optional<Product> findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    public void updateQuantity(Product p, int newQuantity) {
        p.setQuantity(newQuantity);
    }

    public void deleteOutStock() {
        if (isEmpty()) {
            System.out.println("Danh sách sản phẩm trống");
            return;
        }
        products = products.stream().filter(p -> p.getQuantity() != 0).toList();
        System.out.println("Đã xóa thành công các sản phẩm hết hàng");
    }
}
