package pattern;

import entity.DigitalProduct;
import entity.PhysicalProduct;

public interface Factory {
    PhysicalProduct createPhysicalProduct(String id, String name, double price);

    DigitalProduct createDigitalProduct(String id, String name, double price);
}
