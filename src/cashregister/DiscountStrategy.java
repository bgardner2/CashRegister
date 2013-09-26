package cashregister;

public interface DiscountStrategy {
    public abstract double returnDiscountedPrice(double price);
}
