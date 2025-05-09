import java.util.Scanner;

public class Main {

    public static void main(String[] args){

//        user inputs
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.print("Enter Type (A for Adventure ,C for Comedy, SF for Science Fiction, or Q to Quit : ");
            String type = s.nextLine();
            if("Qq".contains(type)){
                break;
            }
            System.out.print("Enter Title: ");
            String title = s.nextLine();

            Movie movie = Movie.getMovie(type,title);
            movie.watchMovie();
        }
    }
}
