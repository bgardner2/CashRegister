package cashregister;

import java.util.Scanner;

public class CashRegister {
   private Scanner keyboard = new Scanner(System.in); 
   private Receipt receipt;
   
   public void startTransaction(String custNo){
       receipt = new Receipt(custNo);
   }
   
   public void addItem(String productID, int qty){
       receipt.addLine(productID, qty);
   }
   
   public String returnCustName(){
       return receipt.getCustomer().getFirstName();
   }
   
   public String printReceipt(){
       return receipt.outputReceipt();
   }
}
