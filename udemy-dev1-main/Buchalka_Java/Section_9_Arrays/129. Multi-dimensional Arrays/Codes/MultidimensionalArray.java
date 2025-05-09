import java.util.Arrays;

public class MultidimensionalArray {
    public static void main(String[] args) {
        int[][] array = new int[4][4];
        System.out.println(Arrays.deepToString(array));
        array[1] = new int[] {10,20,30};
//        array[1] = {10,20,30}; // we can't do this here

        System.out.println(Arrays.deepToString(array));

        Object[] multiArray = new Object[3];
        multiArray[0] = new int[3];
        multiArray[1] = new String[3][];
        multiArray[2] = new double[3][][];

        System.out.println(Arrays.toString(multiArray));
        multiArray[0] = new String[]{"a","b","c"};
        System.out.println(Arrays.deepToString(multiArray));
        multiArray[1] = new String[][]{
                {"1","2"},
                {"3","4","5"},
                {"6","7","8","9"}
        };
        System.out.println(Arrays.deepToString(multiArray));
        multiArray[2] = new int[2][2][2];
//        multiArray[2] = "hello world";
//        multiArray[2] = new String[] {"helloWorld","joker"};
        System.out.println(Arrays.deepToString(multiArray));

        for(Object element : multiArray){
            System.out.println("Element type = "+ element.getClass().getSimpleName());
            System.out.println("Element toString() = "+element);
            System.out.println(Arrays.deepToString((Object[])element));
        }

        int[][]  array1 = new int[4][4];
        array1[0] = new int[]{10,20,30};

        System.out.println(Arrays.deepToString((Object[]) array1 ));
        Integer[][] array2 = new Integer[4][4];
        array2[0] = new Integer[] {10,20,30};

        String[]  str = {"helloWorld","joker"};
        System.out.println(Arrays.deepToString((Object[]) array2 ));
        System.out.println(Arrays.deepToString((Object[]) str));
    }
}
