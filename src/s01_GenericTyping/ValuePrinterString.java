package s01_GenericTyping;

public class ValuePrinterString{

    //private instance variables
    private String val1;
    private String val2;

    //constructor
    public ValuePrinterString(String val1, String val2){
        this.val1 = val1;
        this.val2 = val2;
    }

    public void printValues(){
        System.out.println("Value 1: "+val1);
        System.out.println("Value 2: "+val2);
    }
}
