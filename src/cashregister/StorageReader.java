package cashregister;

public interface StorageReader {
    public abstract Product getProductByID(String itemNo);
    public abstract Customer getCustomerbyID(String custNo);
}
