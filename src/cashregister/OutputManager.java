package cashregister;

public class OutputManager {
    public String INVALID_INPUT = "You entered invalid data into the OutputManager object";
    private OutputStrategy output;
    
    public void setOutputStratetgy(OutputStrategy output){
        if(output == null){
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.output = output;
    }
    
    public OutputStrategy returnOutput(){
        return output;
    }
}
