package presentation;

import exceptions.InvalidProductException;
import models.Product;
import services.ProductService;
import utils.Input;

import java.util.Optional;

class Main {
    private static ProductService productService = new ProductService();

    static void main() {
        int choice;
        do {
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Cập nhật số lượng theo ID");
            System.out.println("4. Xóa sản phẩm đã hết hàng");
            System.out.println("5. Thoát chương trình");
            choice = Input.inputIntegerPositive("Nhập chức năng: ");
            switch (choice) {
                case 1: {
                    int id = (int) (Math.random() * 1000);
                    String name = Input.inputString("Nhập tên: ");
                    double price = Input.inputDoubleInteger("Nhập giá: ");
                    int quantity = Input.inputIntegerPositive("Nhập số lượng: ");
                    String category = Input.inputString("Nhập danh mục: ");
                    Product product = new Product(id, name, price, quantity, category);
                    productService.addProduct(product);
                    System.out.println("Thêm sản phẩm thành công");
                }
                break;
                case 2: {
                    productService.displayAll();
                }
                break;
                case 3: {
                    int id = Input.inputIntegerPositive("Nhập ID sản phẩm: ");
                    Optional<Product> product = productService.findById(id);
                    product.ifPresentOrElse(p -> {
                        int newQuantity = Input.inputIntegerPositive("Nhập số lượng mới: ");
                        productService.updateQuantity(product.get(), newQuantity);
                        System.out.println("Cập nhật số lượng thành công");
                    }, () -> {
                        throw new InvalidProductException("Không tìm thấy sản phẩm");
                    });
                }
                break;
                case 4: {
                    productService.deleteOutStock();
                }
                break;
            }
        } while (choice != 5);
    }
}