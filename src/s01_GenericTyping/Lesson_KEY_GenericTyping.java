package s01_GenericTyping;

public class Lesson_KEY_GenericTyping {

    // Task #1: Write ValuePrinterStrings
    // Task #2: Write ValuePrinterInt
    // Task #3: Write ValuePrinterDouble

    public static void main(String[] args) {
        // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        // TASK #4 KEY
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        // Instructions:
        // 1. Create an object called stringPrinter from the ValuePrinterStrings class. In the constructor, pass in the values "hello" and "world". Call the printValues method on this new object.
        // 2. Create an object called intPrinter from the ValuePrinterInt class. In the constructor, pass in the values 123456789 and 987654321. Call the printValues method on this new object.
        // 3. Create an object called doublePrinter from the ValuePrinterDouble class. In the constructor, pass in the values 32.45 and 76.89. Call the printValues method on this new object.
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - -

        // Task #4
        // 1.
        ValuePrinterString stringPrinter = new ValuePrinterString("hello", "world");
        stringPrinter.printValues();

        // Task #4
        // 2.
        ValuePrinterInt intPrinter = new ValuePrinterInt(123456789, 987654321);
        intPrinter.printValues();

        // Task #4
        // 3.
        ValuePrinterDouble doublePrinter = new ValuePrinterDouble(32.45, 76.89);
        doublePrinter.printValues();

        // - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *


        // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        // TASK #5 KEY
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        // Instructions: Use the ValuePrinterGeneric class to recreate each of the three different printer objects that you created in Task #4.
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        ValuePrinterGeneric<String> genericPrinter1 = new ValuePrinterGeneric<String>("ice","cream");
        genericPrinter1.printValues();

        ValuePrinterGeneric<String> stringPrinter2 = new ValuePrinterGeneric<String>("hello", "world");
        stringPrinter2.printValues();

        ValuePrinterGeneric<Integer> intPrinter2 = new ValuePrinterGeneric<Integer>(123456789, 987654321);
        intPrinter2.printValues();

        ValuePrinterGeneric<Double> doublePrinter2 = new ValuePrinterGeneric<Double>(32.45, 76.89);
        doublePrinter2.printValues();

        // - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
        /*
         * opt:
         *       https://stackoverflow.com/questions/27647407/why-do-we-use-autoboxing-and-unboxing-in-java
         */

    }
}



