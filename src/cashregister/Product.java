package cashregister;

public class Product {
    private Discount discount;
    
    
    private String productName;
    private String productDesc;
    private double cost;
    private double price;
    
    
    public void setDiscountType(Discount discount){
        this.discount = discount;
    }
    
    public void applyDiscount(double price){
        discount.applyDiscount(price);
    }
    
}
