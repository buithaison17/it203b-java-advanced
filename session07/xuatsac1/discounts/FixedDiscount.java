package xuatsac1.discounts;

public class FixedDiscount implements DiscountStrategy {
    private double value;

    public FixedDiscount(double value) {
        this.value = value;
    }

    @Override
    public double applyDiscount(double amount) {
        return amount - value;
    }

    public double getvalue() {
        return value;
    }

    public void setvalue(double value) {
        this.value = value;
    }
}
