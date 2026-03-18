package pattern;

import entity.DigitalProduct;
import entity.PhysicalProduct;

public class ProductFactory implements Factory {

    @Override
    public PhysicalProduct createPhysicalProduct(String id, String name, double price) {
        return new PhysicalProduct(id, name, price);
    }

    @Override
    public DigitalProduct createDigitalProduct(String id, String name, double price) {
        return new DigitalProduct(id, name, price);
    }
}
