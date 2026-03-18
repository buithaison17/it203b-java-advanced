package repository;

import entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDatabase implements IRepository {
    private static ProductDatabase productDatabase;
    private List<Product> products = new ArrayList<>();

    private ProductDatabase() {
    }

    public static ProductDatabase getProductDatabase() {
        if (productDatabase == null) {
            productDatabase = new ProductDatabase();
        }
        return productDatabase;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Thêm sản phẩm thành công");
    }

    @Override
    public void updateProduct(Product product) {
        if (isEmpty()) {
            System.out.println("Danh sách trống");
            return;
        }
        products = products.stream().map(p -> p.getId().equals(product.getId()) ? product : p).toList();
        System.out.println("Cập nhật sản phẩm thành công");
    }

    @Override
    public void deleteProduct(Product product) {
        if (isEmpty()) {
            System.out.println("Danh sách trống");
            return;
        }
        products.remove(product);
        System.out.println("Xóa sản phẩm thành công");
    }

    @Override
    public Optional<Product> findById(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean isEmpty() {
        return products.isEmpty();
    }

    @Override
    public List<Product> findAll() {
        return products;
    }
}
