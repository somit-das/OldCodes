public class Movie {
    private String title;
    public Movie(String title){
        this.title = title;
    }
    public void watchMovie(){
        System.out.println("\n");
        String instanceType = this.getClass().getSimpleName();

        System.out.println("'"+title +"'" + " is a "+ instanceType + " film.");
        System.out.println("\n");
    }
    public static Movie getMovie(String type , String title){  //factory method
        System.out.println("The Type of "+title+ " Movie is "+ type);
        return  switch (type.toLowerCase()){
            case "adventure","A","a" -> new Adventure(title);
            case "comedy","C","c" -> new Comedy(title);
            case "sciencefiction","SF","sf" -> new ScienceFiction(title);
            default -> new Movie(title); // returns movie object
        };
    }
}
class Adventure extends Movie{
    public Adventure(String title){
        super(title);
    }
    public void watchMovie(){
        super.watchMovie();
        System.out.printf(".. %s%n".repeat(3),"Pleasant Scene","Scary Music","Something Bad Happens");
    }
    public void watchAdventure(){
        System.out.println("Watching an Adventure");
    }

}
class Comedy extends  Movie{

    Comedy(String title){
        super(title);
    }
    public void watchMovie(){
        super.watchMovie();
        System.out.printf("..%s%n".repeat(3)," Something funny happens","Something even funnier happens","Happy Ending");
    }
    public  void watchComedy(){
        System.out.println("Watching a Comedy");
    }
}
class ScienceFiction extends  Movie{
    ScienceFiction(String title){
        super(title);
    }
    public void watchMovie(){
        super.watchMovie();
        System.out.printf("..%s%n".repeat(3),"Bad Aliens do Bad Stuff","Space guys Chase Aliens","Planet Blows up");
    }
    public void watchScienceFiction(){
        System.out.println("Watching a Science Fiction");
    }

}

