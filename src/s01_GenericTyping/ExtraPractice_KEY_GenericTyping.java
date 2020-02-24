package s01_GenericTyping;

public class ExtraPractice_KEY_GenericTyping {
    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    Task #4:
    Write a new class called ArrayPrinterStrings as follows:
    1. Declare a private instance variable called **arr** whose type is a 1D String array.
    2. Write a constructor that accepts a single parameter and stores it in the instance variable **arr**.
    3. Write a method called **printArr**. This method should use a for-each loop to print out the contents of **arr**.
    - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    Task #5:
    Write a second class. This class should be identical to the one in Task #1, but it should instead
    be called ArrayPrinterIntegers and work for 1D int arrays rather than 1D String arrays.
    - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    Task #6:
    Write a third class. This class should be identical to the one in Task #1, but it should instead
    be called ArrayPrinterBoolean and work for 1D boolean arrays rather than 1D String arrays.
    - - - - - - - - - - - - - - - - - - - - - - - - - - - - */


    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    Illustration #2:
    Write a fourth class called ArrayPrinterGeneric.
    This single class should have the same functionality as the three different classes created in Tasks #4-6.
    - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
    public static void main(){
        // Arrays to be printed
        int[] intArr = {2,4,6,8};
        double[] doubleArr = {2.1, 3.5, 6.3, 9.7, 90.3};
        String[] stringArr = {"test", "gter", "gewh"};

        //Print using ArrayPrinterIntegers
        ArrayPrinterIntegers intArrPrinter = new ArrayPrinterIntegers(intArr);
        intArrPrinter.printArr();

        //Print using ArrayPrinterDoubles
        ArrayPrinterDoubles doubleArrPrinter = new ArrayPrinterDoubles(doubleArr);
        doubleArrPrinter.printArr();

        //Print using ArrayPrinterStrings
        ArrayPrinterStrings stringArrPrinter = new ArrayPrinterStrings(stringArr);
        stringArrPrinter.printArr();


        //Print using ArrayPrinterGeneric
        Integer[] intObjArr = {2,4,6,8}; // this is the "object" equivalent to: int[] intArr = {2,4,6,8};
        ArrayPrinterGeneric<Integer> intArrPrinter2 = new ArrayPrinterGeneric<Integer>(intObjArr);
        intArrPrinter2.printArr();

        Double[] doubleObjArr = {2.1, 3.5, 6.3, 9.7, 90.3}; // this is the "object" equivalent to: double[] doubleArr = {2.1, 3.5, 6.3, 9.7, 90.3};
        ArrayPrinterGeneric<Double> doubleArrPrinter2 = new ArrayPrinterGeneric<Double>(doubleObjArr);
        doubleArrPrinter2.printArr();

        //Since String is already an object, the existing stringArr works fine here
        ArrayPrinterGeneric<String> stringArrPrinter2 = new ArrayPrinterGeneric<String>(stringArr);
        stringArrPrinter2.printArr();
    }
}
