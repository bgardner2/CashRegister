package cashregister;

public class StorageManager {
    StorageReader storage;
    
    public void setStorageType(StorageReader storage){
        //Need to validate input
        this.storage = storage;
    }
    
    public Customer getCustomerByID(String id){
        //Need to validate input
        return storage.getCustomerbyID(id);
    }
    
    public Product getProductById(String id){
        //Need to validate input
        return storage.getProductByID(id);
    }
}
