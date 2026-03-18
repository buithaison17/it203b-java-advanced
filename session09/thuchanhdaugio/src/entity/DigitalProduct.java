package entity;

public class DigitalProduct extends Product {
    public DigitalProduct(String id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void displayInfo() {
        System.out.println("ID: " + getId() + " | Tên sản phẩm: " + getName() + " | Giá tiền: " + getPrice());
    }
}
