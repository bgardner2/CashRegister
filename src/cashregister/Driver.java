package cashregister;


public class Driver {

    
    public static void main(String[] args) {
        
        CashRegister cr = new CashRegister();
        
        cr.startTransaction("SJ001", new FakeDatabaseReader());
        cr.addItemToReceipt("BC001", 13);
        cr.addItemToReceipt("BC001", 10);//Total baseball caps will be 23
        cr.addItemToReceipt("BS001", 1); //Total Bed Sheets will be 1
        cr.addItemToReceipt("FP001", 2);
        cr.addItemToReceipt("FP001", 3); //Total frying pans will be 5
        System.out.println(cr.printReceipt());
        
        System.out.println("\n\n");
        
        cr.startTransaction("BG001", new FakeDatabaseReader());
        cr.addItemToReceipt("FP001", 2);
        cr.addItemToReceipt("BS001", 1);
        System.out.println(cr.printReceipt());
    }

}
