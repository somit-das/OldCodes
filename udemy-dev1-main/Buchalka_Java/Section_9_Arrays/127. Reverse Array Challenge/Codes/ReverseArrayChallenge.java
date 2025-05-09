import java.util.Arrays;
import java.util.Scanner;

public class ReverseArrayChallenge {
    public static void main(String[] args) {
        int[] returnedArray = readIntegers();
        System.out.println(Arrays.toString(returnedArray));
        System.out.println(Arrays.toString(reverseArray(returnedArray)));
    }
    public static int[] readIntegers(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array Integers by Comma");
        String[] strings = sc.nextLine().split(",");
        int[] newIntArr = new int[strings.length];
        for(int i = 0;i<strings.length;i++){
            newIntArr[i] = Integer.parseInt(strings[i]);
        }
        Arrays.sort(newIntArr);
        return newIntArr;
    }
    public static int[] reverseArray(int[] myArray){
        int temp = 0;
        int[] reversedArr = new int[myArray.length];
        int maxIndex = myArray.length-1;
        for(int el : myArray){
            reversedArr[maxIndex--]=el;
        }
//        return myArray;
        return reversedArr;
    }
	public static void reverseArrayPrint(int [] arr){
		System.out.println("Array = " + Arrays.toString(array));
        int maxIndex = array.length - 1;
        int halfLength = array.length / 2;
        for (int i = 0; i < halfLength; i++) {
            int temp = array[i];                    // 1
            array[i] = array[maxIndex - i];         // 2
            array[maxIndex - i] = temp;             // 3
        }
        System.out.println("Reversed array = " + Arrays.toString(array));
	}

}
