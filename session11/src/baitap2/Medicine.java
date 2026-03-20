package baitap2;

public class Medicine {
    int id;
    String medicine_name;
    int stock;

    public Medicine(int id, String medicine_name, int stock) {
        this.id = id;
        this.medicine_name = medicine_name;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", medicine_name='" + medicine_name + '\'' +
                ", stock=" + stock +
                '}';
    }
}
