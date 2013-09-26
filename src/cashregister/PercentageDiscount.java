package cashregister;

public class PercentageDiscount implements Discount{
    /*
     * TODO
     * Create a setPercentage method
     */
    private final double PERCENT_DISCOUNT = 0.9;
    private final String INVALID_INPUT = "You entered invalid input into the PercentageDiscount object";
    
    @Override
    public double returnDiscountedPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        return price * PERCENT_DISCOUNT;
    }
    
}
