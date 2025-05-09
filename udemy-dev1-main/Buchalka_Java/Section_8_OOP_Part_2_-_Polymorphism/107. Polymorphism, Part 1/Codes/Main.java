public class Main {

    public static void main(String[] args) {

        Movie theMovie = new Movie("Leo");
        theMovie.watchMovie();
        System.out.println("\n\n");
        Movie theAdventure = new Adventure("Bahubali 2 Conclusion");
        theAdventure.watchMovie();
//        The code ran, the watchMovie method on the Adventure class. That's because at runtime, the method that gets run is determined by the Java Virtual machine based on the runtime object and not this variable type. not the variable type ( in this case Movie for example Movie theAdventure)
//         We've declared a variable of type Movie and assigned it an object that's really an Adventure type of movie. So  when we called watchMovie on that, the behavior was the Adventure movies behavior. It wasn't just the base class behavior.




    }
}
/*
    //      obj.getClass() Returns the runtime class of this Object. The returned Class object is the object that is locked by static synchronized methods of the represented class.

    //        obj.getClass().getSimpleName() Returns the simple name of the underlying class as given in the source code. An empty string is returned if the underlying class is anonymous. A synthetic class, one not present in source code, can have a non-empty name including special characters, such as "$".
 */
/*(runtime Polymorphism)
    Polymorphism lets us write code to call a method , but at runtime this method's behavior can be different for different objects.

    This means the behavior that occurs, while the program is executing depends on the runtime type of the object and the runtime type might be different form the declared type in the code.

    The declared type has to have some kind of relationship to the runtime type and inheritance is one way to establish this relationship.

 */