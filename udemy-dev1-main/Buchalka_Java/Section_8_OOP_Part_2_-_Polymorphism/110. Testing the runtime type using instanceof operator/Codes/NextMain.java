public class NextMain {
    public static void main(String[] args) {

        Object unknownObject = Movie.getMovie("Comedy","Airplane");
        Object unknownObject2 = Movie.getMovie("2.0","ScienceFiction");
        Object unknownObject3 = Movie.getMovie("ScienceFiction","Terminator");
        Object unknownObject4 = Movie.getMovie("Adventure","Kantara");

        System.out.println("\n\n\n");



//        using normal getclass().getSimpleName()
        if(unknownObject.getClass().getSimpleName() == "Comedy"){
            Comedy c1 = (Comedy) unknownObject;
            c1.watchComedy();
            c1.watchMovie();
        }
        if(unknownObject2.getClass().getSimpleName()== "Comedy"){
            Comedy c2 = (Comedy) unknownObject2;
            c2.watchComedy();
            c2.watchMovie();
        }

//        using instance of

        if(unknownObject3 instanceof  ScienceFiction){
            ((ScienceFiction) unknownObject3).watchScienceFiction();
            ((ScienceFiction) unknownObject3).watchMovie();
        }

        if(unknownObject4 instanceof  Comedy){
            Comedy c3 = (Comedy)  unknownObject4;
            c3.watchComedy();
            c3.watchMovie();
        }
        // using instanceof variable
        if(unknownObject4 instanceof Adventure indi){ //we don't  have to create the variable in the   block statement, and we don't have to cast it.
            indi.watchAdventure();
            indi.watchMovie();
        }
    }
}
/*
        how do we test what the runtime type of a variable really is at runtime , if the declared type is something else?

        a->
            We can test to see what type the actual object is at runtime  in several different ways.
            1. First, we can use an if statement, to see what  the class name of the object, coming back from  that method is, when this code is running. Getting back to the main method, on the
                ex:-
                     if(unknownObject.getClass().getSimpleName() == "Comedy"){
                            Comedy c = (Comedy) unknownObject;
                            c.watchMovie();
                            c.watchComedy();
                     }

                     Here Here, in this if statement, we're  using a method called getClass on the local variable reference, unknownObject. This method is available to any instance, because it's a method on Object which is a parent of every Class and getSimpleName, is a method that returns the class name of our instance here. This means we're testing if the object, coming back from that factory method,  has a class name that's Comedy or not and if it does, we can cast the object to  Comedy, and assign it to a Comedy variable. Then we can call any method on Comedy. The reason to cast to a Comedy class here is, we want to execute the method that's  specific to Comedy, watchComedy. Without casting to a Comedy class,  we couldn't execute that method or we can't peform downcasting.

                // This code shows you one way to test for the  runtime type, but it's not the best way.

         2. instance of :-
            this operator lets you test the type of object or instance.
                ex:-
                    unknownObject instanceof Adventure
            The reference variable you are testing is left operand ( in above example unknownObject is reference variable that we are testing.)
            The type you are testing for is the right operand (in above example Adventure is type you are testing for)

            This operator returns true , if unknownObject is an instance of Adventure.

            If the JVM can identify the object matches the type, it can extract the data from the object without casting.
                ex-2:
                    unknownObject instanceof ScienceFiction syfy

            For this operator , the object can be assigned to a binding variable (which here is called syfy)

            The variable(syfy , if the instanceof method returns true) is already typed as a ScienceFiction variable.





 */