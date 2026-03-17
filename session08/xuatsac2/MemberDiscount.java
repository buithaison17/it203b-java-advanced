package xuatsac2;

public class MemberDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.05;
    }
}
