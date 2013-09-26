package cashregister;

public class StorageManager {
    private final String INVALID_INPUT = "You entered invalid input into the StorageManager object";
    private StorageReader storage;
    
    
    public void setStorageType(StorageReader storage){
        if (storage == null) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.storage = storage;
    }
    
    public Customer getCustomerByID(String id){
        if (id.length() == 0) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        return storage.getCustomerbyID(id);
    }
    
    public Product getProductById(String id){
        if (id.length() == 0) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        return storage.getProductByID(id);
    }
}
