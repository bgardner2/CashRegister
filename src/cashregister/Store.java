package cashregister;

public class Store {
    //N66W25225 Silver Spring Dr, Sussex, WI‎

    private final String DEFAULT_COMPANY_NAME = "Kohls";
    private final String DEFAULT_STREET1 = "N66W25225 Silver Spring Dr";
    private final String DEFAULT_STREET2 = "";
    private final String DEFAULT_CITY= "Sussex";
    private final String DEFAULT_STATE= "WI";
    private final String DEFAULT_ZIP= "53089";
    private final String DEFAULT_PHONE= "(262) 246-3143";
    
    private String companyName;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    
    /*
     * This default construct should be changed before deployment. It  
     * currently serves as an easy way to test the store.
     */
    public Store(){
        this.companyName = DEFAULT_COMPANY_NAME;
        this.street1 = DEFAULT_STREET1;
        this.street2 = DEFAULT_STREET2;
        this.city = DEFAULT_CITY;
        this.state = DEFAULT_STATE;
        this.zip = DEFAULT_ZIP;
        this.phoneNumber = DEFAULT_PHONE;
    }

    public Store(String companyName, String street1, String street2, String city, String state, String zip) {
        //Need to validate input
        this.companyName = companyName;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        //Need to validate input
        this.companyName = companyName;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        //Need to validate input
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        //Need to validate input
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        //Need to validate input
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        //Need to validate input
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        //Need to validate input
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        //Need to validate input
        this.phoneNumber = phoneNumber;
    }
    // </editor-fold>
    
    
    public String getFormattedAddress(){
        String address = "";
        address += companyName + "\n"
                + street1 + "\n";
        
        if(!street2.equals("") && street2 != null){
            address += street2  + "\n";
        }
        
        address += city + ", "
                + state + zip;
        
        return address;
    }
}
