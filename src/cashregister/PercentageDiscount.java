package cashregister;

public class PercentageDiscount implements Discount{
    private final double PERCENT_DISCOUNT = 0.9;
    @Override
    public double applyDiscountToPrice(double price) {
        return price * PERCENT_DISCOUNT;
    }
    
}
