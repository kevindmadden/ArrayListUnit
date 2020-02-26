package s02_IntroToArrayList;
import java.util.Scanner;

public class TheCaseForArrayList {
    public static void main(String[] args) {
        runProgramRequestingFiveInts();
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