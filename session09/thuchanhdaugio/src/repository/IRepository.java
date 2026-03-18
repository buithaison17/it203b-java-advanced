package repository;

import entity.Product;

import java.util.List;
import java.util.Optional;

public interface IRepository {
    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Product product);

    boolean isEmpty();

    Optional<Product> findById(String id);

    List<Product> findAll();
}
