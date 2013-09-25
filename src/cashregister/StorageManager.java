package cashregister;

public class StorageManager {
    StorageReader storage;
    
    public void setStorageType(StorageReader storage){
        this.storage = storage;
    }
    
    public Customer getCustomerByID(String id){
        return storage.getCustomerbyID(id);
    }
    
    public Product getProductById(String id){
        return storage.getProductByID(id);
    }
}
