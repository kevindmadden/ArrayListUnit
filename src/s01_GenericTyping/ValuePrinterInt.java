package s01_GenericTyping;

public class ValuePrinterInt {

    //private instance variables
    int val1;
    int val2;

    //constructor
    public ValuePrinterInt(int val1, int val2){
        this.val1 = val1;
        this.val2 = val2;
    }

    public void printValues(){
        System.out.println("Value 1: "+val1);
        System.out.println("Value 2: "+val2);
    }
}
