/*
        Reverse way of Sorting in Java

 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayChallenge {
    public static void main(String[] args) {
        int[] arr = new int[]{50,25,80,5,15};
        System.out.println("Before Sorting: "+ Arrays.toString(arr));
        sortingArray(arr);
        System.out.println("After Sorting: "+ Arrays.toString(arr));

        System.out.print("Enter Length of Random Array to Generate: ");
        int[] arr1 = generateArray(new Scanner(System.in).nextInt());
        System.out.println("Before Sorting: "+ Arrays.toString(arr1));
        sortingArray(arr1);
        System.out.println("After Sorting: "+ Arrays.toString(arr1));
    }
    public static int[] sortingArray(int[] arr) {
        int temp = arr[0];
        for(int i = 0; i<arr.length;i++){
            for(int j = 0; j< arr.length-1;j++){
                if(arr[j]<arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
    public static int[] generateArray(int len){
        int[] newArray = new int[len];
        for(int i = 0; i<len;i++){
            newArray[i] = new Random().nextInt(100);
        }
        return newArray;
    }
}
