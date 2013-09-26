package cashregister;

public class Product {
    private final String INVALID_INPUT = "You entered invalid input into the Product Object";
    private Discount discount;
    private String productID;
    private String productDesc;
    private double price;

    public Product(Discount discount, String productID, String productDesc, double price) {
        if (discount == null || productID.length() == 0
                || productDesc.length() == 0 || price < 0) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.discount = discount;
        this.productID = productID;

        this.productDesc = productDesc;

        this.price = price;
    }

    public String getProductID() {
        return productID;
    }

    public void setDiscountType(Discount discount) {
        if (discount == null) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.discount = discount;
    }

    public double returnDiscountedPrice() {
        return discount.returnDiscountedPrice(price);
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        if (productDesc.length() == 0) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.productDesc = productDesc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.price = price;
    }
}
