package s02_IntroToArrayList;
import java.util.Scanner;

public class TheCaseForArrayList {
    public static void main(String[] args) {

        // = = = = = = = = = = = = = = = = = = = = = = = = = = = =
        // = = = = = = = = = = = = = = = = = = = = = = = = = = = =
        //
        // The Case for ArrayList
        //
        // = = = = = = = = = = = = = = = = = = = = = = = = = = = =
        // = = = = = = = = = = = = = = = = = = = = = = = = = = = =


        //This is a small "program" designed to print out whichever five integers the user gives:
        runProgramRequestingFiveInts();

        /*
            1. How could you modify the program so that it prints out whichever SIX integers the user gives it?
                a. What specific things did you need to modify in the existing code?
                b. In particular, how did you have to change the way you created the array?
        */


        /*
            2. How could you modify this program so that the user can enter integers forever until they choose to stop?
            Note that the user should be able to decide to stop typing out more integers anytime they want.
        */


        /*
        Limitations of Arrays:




         */


    }

    public static void runProgramRequestingFiveInts(){
        int numOfValuesToCollect = 5;
        Scanner kb = new Scanner(System.in);
        int[] valuesToStore = new int[numOfValuesToCollect];

        // Intructions to the user on how the game works.
        System.out.println("Welcome to: The Exciting Game!!!... You will be typing in "+numOfValuesToCollect+" different integer numbers.");
        System.out.println("Go ahead and type your first number out below, then hit enter to enter the second, etc.");


        for(int i = 0; i < numOfValuesToCollect; i++){
            System.out.println("___#"+(i+1)+".___");
            valuesToStore[i] = kb.nextInt();
        }

        for(int val : valuesToStore){
            System.out.print(val+", ");
        }
    }

}