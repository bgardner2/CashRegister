package cashregister;

public class FlatRateDiscount implements Discount{

    @Override
    public double applyDiscountToPrice(double price) {
        return price - 2.00;
    }
    
}
