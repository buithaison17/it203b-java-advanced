import entity.Product;
import pattern.Factory;
import pattern.ProductFactory;
import repository.ProductDatabase;
import utils.Input;

import java.util.List;
import java.util.UUID;

public class Main {
    public static void addProduct() {
        ProductFactory factory = new ProductFactory();
        String id = UUID.randomUUID().toString();
        String name = Input.InputString("Nhập tên sản phẩm: ");
        double price = Input.InputDoublePositive("Nhập giá tiền: ");
        int choice;
        do {
            System.out.println("1. Digital");
            System.out.println("2. Physiscal");
            System.out.println("3. Thoat");
            choice = Input.InputIntegerPositive("Nhập sản phẩm muốn tạo: ");
            switch (choice) {
                case 1:
                    Product product = factory.createDigitalProduct(id, name, price);
                    ProductDatabase.getProductDatabase().addProduct(product);
                    return;
                case 2:
                    Product product1 = factory.createPhysicalProduct(id, name, price);
                    ProductDatabase.getProductDatabase().addProduct(product1);
                    return;
                case 3:
                    return;
                default:
                    System.out.println("Chức năng không hợp lệ");
                    break;
            }
        } while (choice != 3);
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Xem danh sách sản phẩm");
            System.out.println("3. Cập nhật thông tin sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Thoát");
            choice = Input.InputIntegerPositive("Nhập lựa chọn: ");
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    List<Product> products = ProductDatabase.getProductDatabase().findAll();
                    products.forEach(p -> p.displayInfo());
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        } while (choice != 5);
    }
}