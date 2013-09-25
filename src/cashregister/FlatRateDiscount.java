package cashregister;

public class FlatRateDiscount implements Discount{

    @Override
    public double returnDiscountedPrice(double price) {
        return price - 2.00;
    }
    
}
