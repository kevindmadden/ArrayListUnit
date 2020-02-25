package s01_GenericTyping;

public class ValuePrinterGeneric<E,T> {

    //private instance variables
    private E val1;
    private E val2;

    //constructor
    public ValuePrinterGeneric(E val1, E val2){
        this.val1 = val1;
        this.val2 = val2;
    }

    public void printValues(){
        System.out.println("Value 1: "+val1);
        System.out.println("Value 2: "+val2);
    }
}
