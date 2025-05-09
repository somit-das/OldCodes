public class Movie {
    private String title;
    public Movie(String title){
        this.title = title;
    }
    public void watchMovie(){
        System.out.println("\n");

        System.out.println(this);// object
        System.out.println(this.getClass()); // class ...
        System.out.println(this.getClass().getSimpleName()); // ...
        String instanceType = this.getClass().getSimpleName();

//    here this refers to current instance
//    when we are calling method(getClass()) on that, we get class type information about the runtime instance on which this method is executing.
//    when again we use getSimpleName() method then  we  get the name of the class
//    so in overall this.getClass().getSimpleName() prints out the class which will be of movie , if we execute this method on a runtime movie object. But when we implement the subclasses and run this method, the runtime object could be an instance of one of those classes for example :- The Adventure class , then we will get class Name of Adventure.

        System.out.println("\'"+title +"\'" + " is a "+ instanceType + " film.");
        System.out.println("\n");

    }
}
class Adventure extends Movie{
    public Adventure(String title){
        super(title);
    }
//    private void watchMovie(){} // 'watchMovie()' in 'Adventure' clashes with 'watchMovie()' in 'Movie'; attempting to assign weaker access privileges ('private'); was 'public'

    public void watchMovie(){
        super.watchMovie();
        System.out.printf(".. %s%n".repeat(3),"Pleasant Scene","Scary Music","Something Bad Happens");
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
}
class ScienceFiction extends  Movie{
    ScienceFiction(String title){
        super(title);
    }
    public void watchMovie(){
        super.watchMovie();
        System.out.printf("..%s%n".repeat(3),"Bad Aliens do Bad Stuff","Space guys Chase Aliens","Planet Blows up");
    }
}
