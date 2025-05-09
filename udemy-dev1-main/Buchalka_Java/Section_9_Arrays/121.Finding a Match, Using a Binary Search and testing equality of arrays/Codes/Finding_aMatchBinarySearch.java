/*
        Arrays.sort() only sort Array by Ascii value.
 */
import java.util.Arrays;

public class Finding_aMatchBinarySearch {
    public static void main(String[] args) {
        String[] sArray = {"Able","jane","Mark","Ralph","David"};
        Arrays.sort(sArray);
        System.out.println(Arrays.toString(sArray));

        String[] sArray2 = {"Able","Jane","Mark","Ralph","David"};
        Arrays.sort(sArray2);
        System.out.println(Arrays.toString(sArray2));
        // binary Search
        if(Arrays.binarySearch(sArray2,"Mark")>= 0){
            System.out.println("Found Mark in the list");
        }

        int[] s1 = {1,2,3,4,5};
        int[] s2 = {1,2,3,4,5};
        if(Arrays.equals(s1,s2)){ // the equals method on Arrays takes two arguments 2 arrays whose types have to match
            System.out.println("s1 and s2 are equal");
        } else {
            System.out.println("s1 and s2 are not equal");
        }

        int[] s3 = {1,2,3,4,5};
        int[] s4 = {5,2,3,4,1};
        if(Arrays.equals(s3,s4)){
            System.out.println("s3 and s4 are equal");
        } else {
            System.out.println("s3 and s4 are not equal");
        }

        int[] s5 = {1,2,3,4,5};
        int[] s6 = {1,2,3,4,5,0};
        if(Arrays.equals(s5,s6)){
            System.out.println("s5 and s6 are equal");
        } else {
            System.out.println("s5 and s6 are not equal");
        }
    }
}
