
/*
        Common Behavior for array would be sorting , initializing values , copying the array, and finding an element.
            For an array, this behavior isn't on the array instance itself , but it's provided on a helper class , java.util.Arrays.

        Arrays.fill( ArrayName , value):- Assigns the specified int value to each element of the specified array of ints.

        Arrays.sort(array):- Sorts the specified array into ascending numerical order.

        Arrays.copyOf():- Copies the specified array, truncating or padding with zeros (if necessary) so the copy has the specified length. For all indices that are valid in both the original array and the copy, the two arrays will contain identical values. For any indices that are valid in the copy but not the original, the copy will contain 0. Such indices will exist if and only if the specified length is greater than that of the original array.

*/


import java.util.Arrays;
import java.util.Random;

public class Java_Util_Array {

    public static void main(String[] args) {
        int[] ArrayInt = getRandomArray(5);
        for(int element:ArrayInt){
            System.out.println(element);
        }
        System.out.println(Arrays.toString(ArrayInt));
        //sorting array.
        Arrays.sort(ArrayInt); // this sort method does not return any thing and belong to Array class
        System.out.println(Arrays.toString(ArrayInt));

        int[] ArrayInt2 = new int[10];
        System.out.println(Arrays.toString(ArrayInt2));
        Arrays.fill(ArrayInt2,6);
        System.out.println(Arrays.toString(ArrayInt2));

        int[] ArrayInt3 = getRandomArray(8);
        System.out.println(Arrays.toString(ArrayInt3));

        int[] ArrayInt4 = Arrays.copyOf(ArrayInt3,ArrayInt3.length);
        Arrays.sort(ArrayInt4);
        System.out.println(Arrays.toString(ArrayInt4));
        System.out.println(Arrays.toString(ArrayInt3));

        int[] smallerArray = Arrays.copyOf(ArrayInt4,5);
        System.out.println(Arrays.toString(smallerArray));

        int[] largerArray = Arrays.copyOf(ArrayInt4,15);
        System.out.println(Arrays.toString(largerArray));
    }
    private static int[] getRandomArray(int len){
        Random random = new Random();
        int[] newInt = new int[len];
//        for(int element:newInt){
//            newInt[element]= random.nextInt(100);
//        } does not works

//        for(int element:newInt){
//            element = random.nextInt(200);
//            System.out.println(random.nextInt(200));
//        }
//        //does not works

        for(int i = 0; i<len ; i++){
            newInt[i] = random.nextInt(100);
        }
        return newInt;
    }

}
