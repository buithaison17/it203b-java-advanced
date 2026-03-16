package xuatsac1.discounts;

public class HolidayDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double amount) {
        return amount - (amount * 0.2);
    }

}
