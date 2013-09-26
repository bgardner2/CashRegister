package cashregister;


public class Driver {
/*
 * Create Output strategy
 * Comments in all classes
 * Validation in all classes
 */
    
    public static void main(String[] args) {
        
        CashRegister cr = new CashRegister();
        
        cr.startTransaction("SJ001", new FakeDatabaseReader(), new ConsoleOutput());
        cr.addItemToReceipt("BC001", 13);
        cr.addItemToReceipt("BC001", 10);//Total baseball caps will be 23
        cr.addItemToReceipt("BS001", 1); //Total Bed Sheets will be 1
        cr.addItemToReceipt("FP001", 2);
        cr.addItemToReceipt("FP001", 3); //Total frying pans will be 5
        cr.endTransaction();
        
        System.out.println("\n\n");
        
        cr.startTransaction("BG001", new FakeDatabaseReader(), new ConsoleOutput());
        cr.addItemToReceipt("FP001", 2);
        cr.addItemToReceipt("BS001", 1);
        cr.endTransaction();

    }

}
