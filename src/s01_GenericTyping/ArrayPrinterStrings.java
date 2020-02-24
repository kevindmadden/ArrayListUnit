package s01_GenericTyping;

public class ArrayPrinterStrings {

    //private instance variable
    String[] arr;

    //constructor
    public ArrayPrinterStrings(String[] arr){
        this.arr = arr;
    }

    public void printArr(){
        System.out.println("Data stored in array: ");
        for(String val : arr){
            System.out.println(val);
        }
    }

}
