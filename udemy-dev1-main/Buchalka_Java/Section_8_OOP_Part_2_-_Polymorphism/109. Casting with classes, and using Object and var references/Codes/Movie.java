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
    public static Movie getMovie(String type , String title){  // here it is a factory method as it returns   a new instance object, is known as a factory method in software programming design patterns. Factory methods give us a way to get an object, without having to know the details of how to create a new one, or specify the exact class we want.

     //    here we getMovie is factory method .We can just call this method, passing the type and name, and the right object type is instantiated, and returned, but it's assigned to a variable with the Movie type, so this code will work for any Movie, or any of its subclasses, including subclasses that haven't even been created yet.
//    This keeps all the information about Movie and it's subclasses, in the control of the Movie class, and simplifies the work that needs to be done, by the calling code. That's why we got achieved a better encapsulation using factory methods

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

/*
?. can factory methods in java helps to achieve encapsulation


Yes, factory methods in Java can indeed help achieve encapsulation. Encapsulation is the concept of bundling data (attributes) and methods (functions) that operate on the data into a single unit, known as a class. By controlling access to the internal state of an object, encapsulation helps maintain the integrity of the data and prevents unintended external interference.

Factory methods are static methods that create instances of a class. They encapsulate the object creation process by providing a centralized location for creating objects, allowing for better control over the object creation process. Here's how factory methods contribute to encapsulation:

1. **Hide Object Creation Logic**: Factory methods encapsulate the logic required to create instances of a class. This logic can involve complex initialization steps, validation, or even object pooling. By encapsulating this logic within the factory method, the details of how objects are created are hidden from the outside world.

2. **Control Object Construction**: Factory methods can enforce certain constraints or rules during object creation. They can perform validation checks on input parameters and decide whether to create an object based on certain conditions. This control over object construction helps ensure that only valid objects are created, thus maintaining the integrity of the system.

3. **Hide Implementation Details**: Factory methods can return instances of subclasses or different implementations of an interface, while the calling code only interacts with the interface or superclass. This allows the factory method to hide the specific implementation details from the client code, promoting loose coupling and abstraction.

4. **Singleton Pattern Implementation**: Factory methods can be used to implement the Singleton pattern, where only one instance of a class is allowed to exist. By controlling the creation of the singleton instance within the factory method and providing a single access point to that instance, encapsulation is maintained, and global access to the instance is controlled.

By utilizing factory methods effectively, you can indeed enhance encapsulation in your Java codebase, leading to better maintainability, flexibility, and robustness.
 */