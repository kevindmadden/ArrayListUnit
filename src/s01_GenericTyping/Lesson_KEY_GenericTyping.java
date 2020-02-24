package s01_GenericTyping;

import java.util.Arrays;

public class Lesson_KEY_GenericTyping {

    // = = = = = = = = = = = = = = = = = = = = = = = = = = = =
    // = = = = = = = = = = = = = = = = = = = = = = = = = = = =
    //
    // The Case for Generic Types
    //
    // = = = = = = = = = = = = = = = = = = = = = = = = = = = =
    // = = = = = = = = = = = = = = = = = = = = = = = = = = = =


    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    Task #1:
    Write a new class called ValuePrinterStrings as follows:
    1. Declare a private instance variable called **val1** of type String.
    2. Declare a private instance variable called **val2** of type String.
    3. Write a constructor that accepts two String parameters and stores them in **val1** and **val2**.
    4. Write a method called **printValues**, which should print each value on the same line with a comma between them.
    - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    Task #2:
    Write a second class. This class should be identical to the one in Task #1, but it should instead
    be called **ValuePrinterInt** and use int types instead of String types.
    - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    Task #3:
    Write a third class. This class should be identical to the one in Task #1, but it should instead
    be called **ValuePrinterDouble** and use double types instead of String types.
    - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    Illustration #1:
    Write a fourth class called ValuePrinterGeneric.
    This single class should have the same functionality as the three different classes created in Tasks #1-3.
    - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    Q&A
    1. Do I need to be able to write my own classes on the AP exam that use generic types?
            No. However, you need to be able to use the ArrayList class, which uses generic typing.
    2. What is the purpose of these exercises?
            a. To show you why generic types are useful.
            b. The ArrayList class (the topic of the unit) uses generic typing. So you DO need to be able
            to use classes on the AP Exam that use generic typing. This should be more straightforward once
            you see what is going on behind the scenes to make generic typing work.
    - - - - - - - - - - - - - - - - - - - - - - - - - - - - */


    public static void main(String[] args) {
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        // Print using "normal" classes:
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        ValuePrinterString stringPrinter = new ValuePrinterString("hello", "world");
        stringPrinter.printValues();
        ValuePrinterInt intPrinter = new ValuePrinterInt(123456789, 987654321);
        intPrinter.printValues();
        ValuePrinterDouble doublePrinter = new ValuePrinterDouble(32.45, 76.89);
        doublePrinter.printValues();


        /*
        * * * * * * * * * * * * * * * * * * * * * *
        NOTES - Generic Typing
        * * * * * * * * * * * * * * * * * * * * * *

        Definition: A generic type is the type you use when you do not know what type you need to use in advance.
        - Think of a generic type as a variable that holds a type.

        Example: See the class ValuePrinterGeneric
        - Instead of a data type like String, int, or double, the letter E is used instead.
        - Notice the <E> when naming the class: **public class ValuePrinterGeneric<E> {**

         */

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
        Integer objInt = 7;

        double normalDouble = 4.5; //primitive double variable
        Double objDouble = 4.5; //integer object wrapper class

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


    // Everything from here and below is for demonstration purposes:

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
    public static void optionalArrayPrinterExercises(){
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



