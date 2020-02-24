package s01_GenericTyping;

public class Lesson_KEY_GenericTyping {

    // Task #1: Write ValuePrinterStrings
    // Task #2: Write ValuePrinterInt
    // Task #3: Write ValuePrinterDouble

    public static void main(String[] args) {
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        // Task #4 Key
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        // 1. Create an object called stringPrinter from the ValuePrinterStrings class. In the constructor, pass in the values "hello" and "world". Call the printValues method on this new object.
        // 2. Create an object called intPrinter from the ValuePrinterInt class. In the constructor, pass in the values 123456789 and 987654321. Call the printValues method on this new object.
        // 3. Create an object called doublePrinter from the ValuePrinterDouble class. In the constructor, pass in the values 32.45 and 76.89. Call the printValues method on this new object.
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - -

        // 1.
        ValuePrinterString stringPrinter = new ValuePrinterString("hello", "world");
        stringPrinter.printValues();

        // 2.
        ValuePrinterInt intPrinter = new ValuePrinterInt(123456789, 987654321);
        intPrinter.printValues();

        // 3.
        ValuePrinterDouble doublePrinter = new ValuePrinterDouble(32.45, 76.89);
        doublePrinter.printValues();



        // - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        // Print using the same class, which uses a generic type:
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        ValuePrinterGeneric<String> stringPrinter2 = new ValuePrinterGeneric<String>("hello", "world");
        stringPrinter2.printValues();

        ValuePrinterGeneric<Integer> intPrinter2 = new ValuePrinterGeneric<Integer>(123456789, 987654321);
        intPrinter2.printValues();

        ValuePrinterGeneric<Double> doublePrinter2 = new ValuePrinterGeneric<Double>(32.45, 76.89);
        doublePrinter2.printValues();


        // Q: Why use Integer and Double instead of int and double?
        // A: See next section of notes!

        /*
        * * * * * * * * * * * * * * * * * * * * * *
        Notes - The Integer and Double Wrapper Classes
              - Autoboxing and Unboxing
        * * * * * * * * * * * * * * * * * * * * * *
        WARNING
        - This is Java-specific, not programming-specific.
        - Remember how I said I was teaching you how to program and not Java?
        - For this specific section of notes, I'm teaching you Java.

        REVIEW - Java has two primary data types:
            -Primitives: int, double, boolean (not on AP Exam: char, float, long, short, byte)
            -Objects: literally everything else, including String

        IMPORTANT - Generic types in Java only work for object data types, NOT primitive data types.
          HOWEVER - The primitive types all have corresponding WRAPPER CLASSES.

        */

        int normalInt = 7; //primitive int variable
        Integer objInt = 7; //Integer object wrapper class

        double normalDouble = 4.5; //primitive double variable
        Double objDouble = 4.5; //Double object wrapper class

        //Two methods on the AP Cheat Sheet you should know about:
        Integer objInt_DEPRECATED = new Integer(7); //integer object wrapper class
        Double objDouble_DEPRECATED = new Double(4.5);

        /*
        NOTES - Continued

        Autoboxing: when Java automatically converts from a primitive type to its object-wrapper-class type.
        Unboxing:   when Java automatically converts in the reverse direction from above ^^.

        How to remember?
        -Unboxing removes the extra complexity; it "undoes" the "box," revealing only the primitive


        VAR-1.F.4:
            Autoboxing is the automatic conversion that
            the Java compiler makes between primitive
            types and their corresponding object wrapper
            classes. This includes converting an int to an
            Integer and a double to a Double.

        VAR-1.F.5
            The Java compiler applies autoboxing when a
            primitive value is:
                -Passed as a parameter to a method that
                expects an object of the corresponding
                wrapper class.
                -Assigned to a variable of the corresponding
                wrapper class.

        VAR-1.F.6
            Unboxing is the automatic conversion that the
            Java compiler makes from the wrapper class
            to the primitive type. This includes converting
            an Integer to an int and a Double to a
            double.

        VAR-1.F.7
            The Java compiler applies unboxing when a
            wrapper class object is:
            -Passed as a parameter to a method that
            expects a value of the corresponding
            primitive type.
            -Assigned to a variable of the corresponding
            primitive type.
         */

        /*
         * opt:
         *   Data Types in Java:
         *       https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
         *   Primitive Wrapper Classes:
         *       https://stackoverflow.com/a/8660812
         *   Auto-boxing/Unboxing
         *       https://stackoverflow.com/questions/27647407/why-do-we-use-autoboxing-and-unboxing-in-java
         */

    }
}



