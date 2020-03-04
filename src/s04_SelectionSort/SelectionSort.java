package s04_SelectionSort;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {

    public static void main(String[] args){
        List<Integer> arr = generateRandIntArrayList();

        for(int k = 0; k < arr.size(); k++) {
            int indexOfSmallestNum = k;
            for (int i = k; i < arr.size(); i++) {
                if(arr.get(i) < arr.get(indexOfSmallestNum)){
                    indexOfSmallestNum = i;
                }
            }
            int leftVal = arr.get(k);
            int rightVal = arr.get(indexOfSmallestNum);
            arr.set(k, rightVal);
            arr.set(indexOfSmallestNum, leftVal);
        }

        printIntList(arr);
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

        for(int i = 0; i < list.size()-1; i++){
            int left = list.get(i);
            int right = list.get(i+1);
            System.out.print(list.get(i)+", ");
            if(left<right){
                isInOrderDESC = false; //System.out.print("l<r");
            }
            if(left>right){
                isInOrderASC = false; //System.out.print("l>r");
            }
        }
        System.out.println();
        if(isInOrderASC) System.out.print("TRUE (ASC order)");
        if(isInOrderDESC) System.out.print("TRUE (DESC order");
        if(!isInOrderASC && !isInOrderDESC) System.out.print("FALSE - Not in order");
        System.out.println();
        System.out.println();



    }

}
