package s01_GenericTyping;

public class ArrayPrinterGeneric<E> {

    //private instance variable
    E[] arr;

    //constructor
    public ArrayPrinterGeneric(E[] arr){
        this.arr = arr;
    }

    public void printArr(){
        System.out.println("Data stored in array: ");
        for(E val : arr){
            System.out.println(val);
        }
    }
}
