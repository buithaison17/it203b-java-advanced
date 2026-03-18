package entity;

public class PhysicalProduct extends Product {
    public PhysicalProduct(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void displayInfo() {
        System.out.println("ID: " + getId() + " | Tên sản phẩm: " + getName() + " | Giá tiền: " + getPrice());
    }
}
