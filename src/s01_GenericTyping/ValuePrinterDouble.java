package s01_GenericTyping;

public class ValuePrinterDouble {

    //private instance variables
    private double val1;
    private double val2;

    //constructor
    public ValuePrinterDouble(double val1, double val2){
        this.val1 = val1;
        this.val2 = val2;
    }

    public void printValues(){
        System.out.println("Value 1: "+val1);
        System.out.println("Value 2: "+val2);
    }
}
