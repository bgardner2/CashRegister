package cashregister;

public class Product {
    private Discount discount;
    private String productID;
    private String productDesc;
    private double price;
    

    public Product(Discount discount, String productID,  String productDesc, double price) {
        //Need to validate input
        this.discount = discount;
        this.productID = productID;
        
        this.productDesc = productDesc;
        
        this.price = price;
    }
    
    public String getProductID(){
        return productID;
    }
    
    public void setDiscountType(Discount discount){
        //Need to validate input
        this.discount = discount;
    }
    
    public double returnDiscountedPrice(){
        return discount.returnDiscountedPrice(price);
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        //Need to validate input
        this.productDesc = productDesc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        //Need to validate input
        this.price = price;
    }
    
}
