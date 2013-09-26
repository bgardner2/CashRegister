package cashregister;

public class FlatRateDiscount implements Discount{

    @Override
    public double returnDiscountedPrice(double price) {
        //Need to validate input
        return price - 2.00;
    }
    
}
