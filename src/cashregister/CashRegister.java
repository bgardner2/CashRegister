package cashregister;

public class CashRegister {
    //TODO add endTransaction() method that calls the receipts output method
   private Receipt receipt;
   
   /**
    * This method starts a transaction by looking for a customer number (@param custNo)
    * in a datasource (@param reader) by passing it to a receipt object
    * @param custNo
    * @param reader 
    */
   public void startTransaction(String custNo, StorageReader reader){
       if(custNo.length() <= 0 || reader == null)
       {
           throw new IllegalArgumentException("Please enter valid data");
       }
       
       receipt = new Receipt(custNo, reader);
       
       
   }
   
   /**
    * This method passes a productID and a quantity to a receipt object 
    * so the receipt can add the information to a line
    * @param productID
    * @param qty 
    */
   public void addItemToReceipt(String productID, int qty){
       if(productID.length() <= 0 || qty < 0)
       {
           throw new IllegalArgumentException("Please enter valid data");
       }
       receipt.addItemToLine(productID, qty);
   }
   
   /**
    * This method returns the first name of the customer object 
    * in the receipt object
    * @return 
    */
   public String returnCustName(){
       return receipt.getCustomer().getFirstName();
   }
   
   //TODO move this method to the receipt object (display strategy)
   public String printReceipt(){
       return receipt.outputReceipt();
   }
}
