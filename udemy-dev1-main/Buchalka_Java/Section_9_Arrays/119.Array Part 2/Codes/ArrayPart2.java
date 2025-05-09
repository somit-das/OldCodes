import java.util.Arrays;

/*
        Enhanced For Loop
        -----------------
            - Here first part is a declaration expression which includes the type and a variable name. This is usually a local variable with the same type as an element in the array.

            - Second component is the array or some other collection variable.
            for,(declaration : collection){
                // block of statements;
            }
        Basic For Loop
        ---------------
            for(init; expression; increment){
                //bock of statements.
            }

*/
public class ArrayPart2 {
    public static void main(String[] args) {

        int[] newArray;
        newArray = new int[5];
        System.out.println(newArray);

        for(int i = 0; i < newArray.length;i++){
            newArray[i] = newArray.length - i;
        }
        for(int i = 0; i < newArray.length;i++){
            System.out.print(newArray[i] + " ");
        }

        System.out.println("\n");
        for(int element : newArray){
            System.out.print(element + " ");
        }
        System.out.println();

//        toString method in java.util.arrays prints out all the array elements , comma delimited and contained in square brackets.
        // it prints the element at index 0 first , followed by a comma , then element at index 1 , .. until all elements are printed . [ e1, e2 , e3....]
        String arrayElementsInAString = Arrays.toString(newArray);
        System.out.println(arrayElementsInAString);

        Object objectVariable = newArray; ////upcasting
        if(objectVariable instanceof int[]){ //checking if objectVariable containing object is type of int[] or not.
            System.out.println("objectVariable is really an int array");
            System.out.println(objectVariable);
        }


        Object[] objectArray = new Object[3];
        objectArray[0] = "Hello";
        objectArray[1] = new StringBuilder("World");
        System.out.println(Arrays.toString(objectArray));
    }
}
//      Using object[] can we store different datatype variables in java ?

/*
        Yes, in Java, you can store different types of variables in an `Object[]` array because `Object` is the superclass of all classes in Java. This allows you to store any type of object within the array. Here's an example:

        ```Example
        public class Main {
            public static void main(String[] args) {
                Object[] array = new Object[5];

                array[0] = 1; // Integer
                array[1] = "Hello"; // String
                array[2] = 3.14; // Double
                array[3] = new java.util.Date(); // Date
                array[4] = true; // Boolean

                for (Object item : array) {
                    System.out.println(item);
                }
            }
        }
        ```

        In this example:
        - `1` is stored as an `Integer`
        - `"Hello"` is stored as a `String`
        - `3.14` is stored as a `Double`
        - A `java.util.Date` object is stored as a `Date`
        - `true` is stored as a `Boolean`

        Each of these different types can coexist in the `Object[]` array because they all ultimately derive from `Object`.
 */