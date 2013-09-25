package cashregister;

public class Product {
    private Discount discount;
    private String productID;
    private String productDesc;
    private double price;
    

    public Product(Discount discount, String productID,  String productDesc, double price) {
        this.discount = discount;
        this.productID = productID;
        
        this.productDesc = productDesc;
        
        this.price = price;
    }
    
    public String getProductID(){
        return productID;
    }
    
    public void setDiscountType(Discount discount){
        this.discount = discount;
    }
    
    public double returnDiscountedPrice(){
        return discount.returnDiscountedPrice(price);
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
}
