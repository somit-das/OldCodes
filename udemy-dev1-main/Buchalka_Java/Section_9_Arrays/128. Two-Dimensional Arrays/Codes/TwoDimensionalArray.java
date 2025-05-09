import java.util.Arrays;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        int[][] array = new int[4][4];
        System.out.println(Arrays.toString(array)); //printing 2d array using toString()

//      2d Array initializing
        for(int i = 0;i < array.length;i++){
            var innerArray = array[i];
            for(int j = 0;j < innerArray.length; j++){
//                System.out.print(array[i][j]+" ");
                array[i][j] = (i*10)+(j+1);
            }
//            System.out.println();
        }
        System.out.println("array.length = "+array.length);

//        Printing 2d Array using for loop and to String
        for(int[] outer:array){
            System.out.println(outer);
            System.out.println(Arrays.toString(outer));
        }

        System.out.println();

//        printing 2d Array using using for loop
        for(var outer: array){
            for(var element:outer){
                System.out.print(element+ " ");
            }
            System.out.println();
        }

//        pringting 2d Array using deepToString
        System.out.println(Arrays.deepToString(array)); // printing 2d array using deepToString()
    }
}
