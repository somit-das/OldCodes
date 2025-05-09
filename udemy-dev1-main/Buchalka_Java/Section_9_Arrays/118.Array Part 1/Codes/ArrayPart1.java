/*
    Array is a data structure that allows you to store a sequence of values all the same type .  An array is a special class in java. like all other classes , ultimately it inherits from java.lang.Object

    You can have arrays for any primitive type like ints, doubles, booleans ... also you can have arrays for any class.
    Elements in an array are indexed start at 0.

    Array Variable Declaration ways:-
        int[] integerArray;
        String[] nameList;
        String courseList[];

    Instantiating Array:-
        One way to instantiate the array is with new keyword although String does not  need to new keyword.
    Array Creation:-
        array declaration =  array expression.
        int[] integerArray = new int[10];
        - Array instantiation doesn't have a set of parentheses , meaning we can't pass data to a constructor for an array. for example :- int[] integerArray = new int[10](); will give C.T.E.

    Object Creation:-
        object declaraion = object creation
        StringBuilder sb = new StringBuilder();

 */

public class ArrayPart1 {
    public static void main(String[] args) {
        int[] myIntArray = new int[10];
        myIntArray[5] = 43;
        myIntArray[1] = 90;
        myIntArray[0] = 12;

        double[] myDoubleArray = new double[10];
        myDoubleArray[2] = 3.4;
        System.out.println(myDoubleArray[2]);

        // Array Initializer , makes the job of instantiating and initializing a small array , much easier.
        int[] myIntArray2 = new int[]{1,2,3,4,5};
//        int[] myIntArray3 = new int[33]{1,2,3,4,5};// error.
        System.out.println("first = "+ myIntArray2[0]);
        System.out.println("length of array = "+myIntArray2.length);

        System.out.println("Last Array element : "+myIntArray2[myIntArray2.length-1]);

        int[] newArray = {5,56,76,4,2};// newArray is assigned with anonymous array.

        int[] newArray2 ;
        newArray2 = new int[]{1,2,3,4,55,5}; // this(different line ) with array initialization using newInt[] is allowed
        //newArray2 = {1,2,3,4,55,5}; // but this(different line) with anonymous array initialization is not allowed

        // intializing array with default value of the type or 0 in int case. for primitive type , this
        int[] newArray3;
        newArray3 = new int[5];
        for(int i = 0; i < newArray3.length;i++){
            System.out.print(newArray3[i] + " ");
        }
        for(int i = 0; i < newArray3.length;i++){
            newArray3[i] = newArray3.length - i;
        }
        System.out.println("\n");
        for(int i = 0; i < newArray3.length;i++){
            System.out.print(newArray3[i] + " ");
        }
        System.out.println("\n");
        System.out.println(newArray);
        System.out.println(newArray2);
        System.out.println(newArray3);
    }
}
