package xuatsac2;

public class FirstTimeDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double amount) {
        return amount * 0.15;
    }
}
