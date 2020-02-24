package s01_GenericTyping;

public class ArrayPrinterIntegers {

    //private instance variable
    int[] arr;

    //constructor
    public ArrayPrinterIntegers(int[] arr){
        this.arr = arr;
    }

    public void printArr(){
        System.out.println("Data stored in array: ");
        for(int val : arr){
            System.out.println(val);
        }
    }
}
