package s03_BubbleSort;

import java.util.*;

public class BubbleSort {
    public static void main(String[] args) {
        bubbleSortChoiceA();
        //bubbleSortChoiceB(); //out of bounds error
        bubbleSortChoiceC();
        bubbleSortChoiceD();
        bubbleSortChoiceE();
    }

    //Modified Correct: (<= instead of > for left, right comparison)
    public static void bubbleSortChoiceA(){
        System.out.println("Choice A");
        List<Integer> bubbleSort = generateRandIntArrayList();
        for(int k = 0; k < bubbleSort.size()-1; k++){
            boolean isInOrder = true;
            for(int i=0; i < bubbleSort.size()-1-k; i++){
                int left = bubbleSort.get(i);
                int right = bubbleSort.get(i+1);
                if(left <= right){
                    bubbleSort.set(i+1, left);
                    bubbleSort.set(i, right);
                    isInOrder = false;
                }
            }
            if(isInOrder){
                break;
            }
        }
        printIntList(bubbleSort);
    }

    //INCORRECT
    //Modified incorrect: -1 removed from second for loop, resulting in out of bounds error
    //Modified Correct: (<= instead of > for left, right comparison)
    /*public static void bubbleSortChoiceB(){
        System.out.println("Choice B");
        List<Integer> bubbleSort = generateRandIntArrayList();
        for(int k = 0; k < bubbleSort.size()-1; k++){
            for(int i=0; i < bubbleSort.size()-k; i++){
                int left = bubbleSort.get(i);
                int right = bubbleSort.get(i+1);
                if(left <= right){
                    bubbleSort.set(i+1, left);
                    bubbleSort.set(i, right);
                }
            }
        }
        printIntList(bubbleSort);
    }*/

    //Initial Correct
    public static void bubbleSortChoiceC(){
        System.out.println("Choice C");
        List<Integer> bubbleSort = generateRandIntArrayList();
        for(int k = 0; k < bubbleSort.size()-1; k++){
            for(int i=0; i < bubbleSort.size()-1-k; i++){
                int left = bubbleSort.get(i);
                int right = bubbleSort.get(i+1);
                if(left > right){
                    bubbleSort.set(i+1, left);
                    bubbleSort.set(i, right);
                }
            }
        }
        printIntList(bubbleSort);
    }

    //INCORRECT
    //Modified incorrect from E: temp variable no longer stored for right or left, which potentially overwrites the left side
    //Modified Correct (change left from i => i-1, right from i+1 => i); also, changed so i,k start at 1 but stop at final index (rather than -1)
    public static void bubbleSortChoiceD(){
        System.out.println("Choice D");
        List<Integer> bubbleSort = generateRandIntArrayList();
        for(int k = 1; k < bubbleSort.size(); k++){
            for(int i=1; i < bubbleSort.size()-k; i++){
                if(bubbleSort.get(i) <= bubbleSort.get(i-1)){
                    bubbleSort.set(i-1, bubbleSort.get(i));
                    bubbleSort.set(i, bubbleSort.get(i-1));
                }
            }
        }
        printIntList(bubbleSort);
    }

    //Modified Correct (change left from i => i-1, right from i+1 => i); also, changed so i starts at 1 but stops at final index (rather than final index-1)
    public static void bubbleSortChoiceE(){
        System.out.println("Choice E");
        List<Integer> bubbleSort = generateRandIntArrayList();
        for(int k = 0; k < bubbleSort.size()-1; k++){
            for(int i=1; i < bubbleSort.size()-k; i++){
                int left = bubbleSort.get(i-1);
                if(left > bubbleSort.get(i)){
                    bubbleSort.set(i-1, bubbleSort.get(i));
                    bubbleSort.set(i, left);
                }
            }
        }
        printIntList(bubbleSort);
    }








    public static List<Integer> generateRandIntArrayList(){
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 200; i++){
            list.add((int)(Math.random()*100));
        }
        printIntList(list);
        return list;

    }

    public static void printIntList(List<Integer> list){
        boolean isInOrderASC = true;
        boolean isInOrderDESC = true;

        for(int i = 0; i < list.size(); i++){
            if(i > 0){
                int left = list.get(i-1);
                int right = list.get(i);
                System.out.print(list.get(i)+", ");
                if(left<right){
                    isInOrderDESC = false;
                }
                if(left>right){
                    isInOrderASC = false;
                }

            }

        }
        if(isInOrderASC) System.out.print("TRUE (ASC order)");
        if(isInOrderDESC) System.out.print("TRUE (DESC order");
        if(!isInOrderASC && !isInOrderDESC) System.out.print("FALSE - Not in order");
        System.out.println();
        System.out.println();



    }


}
