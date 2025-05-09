import java.util.Arrays;
import java.util.Scanner;

public class MinimumElementChallenge {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter Number by Comma Separated :- ");
        String input = sc.nextLine();
        String[] str = input.split(",");

        System.out.println("Entered Array : - "+Arrays.toString(str));
        int[] arraY1 = readIntegers(str);
        System.out.println(Arrays.toString(arraY1));
        System.out.println("Minimum Value in Given Array: "+ minimumInt(arraY1));

    }
    public static int[] readIntegers(String ... str){

        int[] newArray = new int[str.length];
        int i = 0;
        for(String s : str){
            newArray[i]= Integer.parseInt(s);
            i++;
        }
        return newArray;
    }
    public static int minimumInt(int[] array){
        int min = Integer.MAX_VALUE;
        for(int i:array){
            if(i<min)
                min = i;
        }
        return min;
    }


}
