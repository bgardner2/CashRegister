package cashregister;

public class Store {
    private final String INVALID_INPUT = "You entered invalid input into the Store object";
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
        if(companyName.length() == 0 || street1.length() == 0 || 
                street2.length() == 0 || city.length() == 0 || 
                state.length() == 0 || zip.length() == 0){
            throw new IllegalArgumentException(INVALID_INPUT);
            
        }
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
        if(companyName.length() == 0){
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.companyName = companyName;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        if(street1.length() == 0){
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        if(street2.length() == 0){
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if(city.length() == 0){
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        if(state.length() == 0){
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        if(zip.length() == 0){
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.zip = zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.length() == 0){
            throw new IllegalArgumentException(INVALID_INPUT);
        }
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
