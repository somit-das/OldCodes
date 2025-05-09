import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Movie theLeo = Movie.getMovie("Action","Leo");

        theLeo.watchMovie();
        System.out.println("\n\n");

        Movie theBahubali = Movie.getMovie("Action","Bahubali 2 Conclusion");
        theBahubali.watchMovie();

        System.out.println("\n\n");

        Movie theKantara = Movie.getMovie("Adventure","Kantara");
        theKantara.watchMovie();

        System.out.println("\n\n");

        Movie theGolMaal = Movie.getMovie("Comedy","GolMaal");
        theGolMaal.watchMovie();

        System.out.println("\n\n");

        Movie theDrishyam2 = Movie.getMovie("Drama","Drishyam");
        theDrishyam2.watchMovie();

        System.out.println("\n\n");

        Movie theKanchana = Movie.getMovie("Horror", "Kanchana");
        theKanchana.watchMovie();

        System.out.println("\n\n");

        Movie theTerminator = Movie.getMovie("ScienceFiction","Terminator");
        theTerminator.watchMovie();

        System.out.println("\n\n");

        Movie the2_0 = Movie.getMovie("IndiScienceFiction","2.0");
        the2_0.watchMovie();

        System.out.println("\n\n");

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
