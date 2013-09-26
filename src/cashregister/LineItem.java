package cashregister;

public class LineItem {

    private final String INVALID_INPUT = "You have entered invalid input in the LineItem object";
    private Product product;
    private int itemQty = 0;
    private StorageManager sm = new StorageManager();

    public LineItem(String productID, int qty) {
        if (productID.length() == 0 || qty <= 0) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        sm.setStorageType(new FakeDatabaseReader());
        Product p = sm.getProductById(productID);
        addProduct(p);
        setItemQty(qty);

    }

    public double returnDiscountedPrice() {
        return product.returnDiscountedPrice();
    }

    public Product getCurrentLineProduct() {
        return product;
    }

    private void addProduct(Product p) {
        if (p == null) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        product = p;

    }

    public int getItemQty() {
        return itemQty;
    }

    public void setItemQty(int itemQty) {
        if (itemQty <= 0) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.itemQty = itemQty;

    }
}
