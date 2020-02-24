package s01_GenericTyping;

public class ArrayPrinterDoubles {

    //private instance variable
    double[] arr;

    //constructor
    public ArrayPrinterDoubles(double[] arr){
        this.arr = arr;
    }

    public void printArr(){
        System.out.println("Data stored in array: ");
        for(double val : arr){
            System.out.println(val);
        }
    }
}
