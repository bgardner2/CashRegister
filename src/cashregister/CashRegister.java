package cashregister;

import java.util.Scanner;

public class CashRegister {
   private Scanner keyboard = new Scanner(System.in); 
   private Receipt receipt;
   
   public void startTransaction(String custNo, StorageReader reader){
       receipt = new Receipt(custNo, reader);
       
   }
   
   public void addItemToReceipt(String productID, int qty){
       receipt.addItemToLine(productID, qty);
   }
   
   public String returnCustName(){
       return receipt.getCustomer().getFirstName();
   }
   
   public String printReceipt(){
       return receipt.outputReceipt();
   }
}
