public class NextMain {
    public static void main(String[] args) {
//        Movie movie = Movie.getMovie("A","Jaws");
//        movie.watchMovie();

//        Adventure jaws = Movie.getMovie("A","Jaws"); //In this case, we declared that the method,  getMovie, is going to return a Movie Class. We didn't say it was going to return an instance of the Adventure Class. The compiler asks the question, can every kind of  Movie (which is the return type of this method), be called an Adventure, meaning, can every kind  of Movie be assigned to an Adventure variable? And here, the answer is no. The Adventure reference, jaws, would not be able to handle a Comedy  movie, if that got returned, for example. That's because we can't say a Comedy is an Adventure. But we absolutely know that when we pass the letter A or Adventure  as the type, that we'll get an Adventure movie back. But the compiler can't figure that out, without  executing code, and it's not going to do that.

//        Now, we can give the compiler more detailed  instructions, to get around this issue. One Way to do this is casting . Like casting with primitives, we can cast instances, so let's do that here. We'll cast the result of the Movie.getMovie, to an Adventure type. And we'll also add the call to watchMovie here. REMEMBER FOR UPCASTING ( SUPERCLASS INSTVAR = SUBCLASS OBJECT) TYPECASTING(CLASSTYPE) IS NOT REQUIRED AS THIS CASTING IS IMPLICIT DONE BUT FOR DOWNCASTING THE TYPECASTING IS REQUIRED WITH COMPATIBLE TYPE.


        //typecasting (downcasting) the (upcasted object)
        Adventure jaws2 = (Adventure) Movie.getMovie("Adventure","Jaws"); // downcasting occurs.
        jaws2.watchMovie();


//        Adventure jaws3 = (Adventure) Movie.getMovie("Comedy","Jaws"); //  java.lang.ClassCastException , class Comedy cannot be cast to class Adventure
//        jaws3.watchMovie();

//        Adventure terminator1 = (Adventure) Movie.getMovie("SF","Terminator"); //  java.lang.ClassCastException , class Science Fiction and it cannot be cast to class Adventure
//        terminator1.watchMovie();


//        Object

        Object comedy1 = Movie.getMovie("Comedy","Dhamaal");
//        comedy1.watchMovie();
//        comedy1.watchComedy();
        /* Here, now we've created a variable called  comedy, but we've said its type is Object and this code doesn't compile, but not on the  first line where we're doing the assignment, but on the second statement.  The compiler won't use the method return type, to figure out what comedy really is, after you make this assignment. It just assumes it's an Object, and this variable only has access to Object's functionality. This is because, at any time in the code, an instance of Object itself could be assigned to this variable. The code has to work for whatever  object gets assigned, to this variable. This means that when you try to call a Movie method, on this object reference, you'll get an error. This is because the compiler can't locate that method (watchMovie) on the Object class.if we try to run watchComedy on that Object variable, we have the same problem that we had with watchMovie: It doesn't see that method watchComedy on the  Object class, and it's not going to compile.

            Now, you could assign every instance to an Object reference or parent class reference  like this, but you  wouldn't be able to do much with them,Other than accessing methods , we can not able to access methods in child class and if same methods as parent class methods present in child class , then only for that case child class method invoked because of method overriding.
         */
        Movie comedyMovie1 = (Movie) comedy1;  // downcasting the upcasted object
        comedyMovie1.watchMovie();

//        comedyMovie1.watchComedy(); // This doesn't compile either. For the same reason we couldn't  execute watchMovie on an Object reference, we  can't run watchComedy on just a Movie reference.  The compiler will only look at the reference  type, to determine if that method is on that type, and watchComedy, is not on the Movie class. In this case, we'd need to actually cast to   a more specific type, Comedy.


        Comedy comedyMovie2 = (Comedy) comedy1;
        comedyMovie2.watchMovie();
        comedyMovie2.watchComedy();



    }
}
/*
What is compile time type ?
a->     The declared type or compile-time type of a variable is the type that is used in the declaration.

*/


/*
    Run Time vs Compile Time Typing
    -> Why are runtime types different than compile time types because of polymorphism. for example in the example above the "using single compile time type of Movie actually supported four different runtime types.Each type was able to execute behavior unique to the class"

    -> You can think of the compile time type as the declared type.

    -> This Compile time typing is declared either as a variable reference,  or a method return type, or a method parameter, for example. In the case of LVTI (Local Variable Type Inference), we don't declare  a type for the compiled reference type, it gets inferred, but the byte code after compilation is the same, as if we had declared it.

    -> in many cases the compile time type is the declared type to the left of the assignment operator. what is returned on the right side of assignment operator from whatever expression or method is executed,sometimes can only be determined at runtime , when the code is executing conditionally through the statements in the code.
    -> You can assign a runtime instance, to a different compile time type, only if certain rules are followed.

    -> We can assign an instance to a variable  of the same type, or a parent type,  or a parent's parent type, including java.lang.Object, the ultimate base class.
        ex:-
        In Java, you can assign an instance of a class to a variable of the same type, a superclass type, or any type higher up in the inheritance hierarchy, including `java.lang.Object`, which is the ultimate base class for all Java classes. This is possible due to polymorphism, which allows objects of subclasses to be treated as instances of their superclass.

        Here's a breakdown of how this works:

        1. **Assigning to the Same Type**:
            - You can assign an instance of a class to a variable of the same type without any issues.

                ```java
                class Animal { }
                Animal animal = new Animal();
                ```

        2. **Assigning to a Parent Type**:
             - You can assign an instance of a subclass to a variable of its superclass type.

                ```java
                class Dog extends Animal { }
                Dog dog = new Dog();
                Animal animal = dog; // Assigning a Dog instance to an Animal variable
                ```

        3. **Assigning to a Parent's Parent Type**:
              - Similarly, you can assign an instance to a variable of a type higher up in the inheritance hierarchy.

                ```java
                Object obj = animal; // Assigning an Animal instance to an Object variable
                ```

                By allowing these types of assignments, Java promotes flexibility and code reuse. It also facilitates polymorphism, where objects of different subclasses can be treated uniformly based on their common superclass or interface. However, it's essential to note that when assigning to a superclass or higher-level type, you may lose access to subclass-specific methods or properties unless you perform a downcast (type casting) to the subclass type. Additionally, if the superclass or higher-level type is too general (e.g., `Object`), you may need to cast back to the original type to access its specific members.
    ->
 */


/*
    run time vs compile time typing
a->

    "Compile-time typing" and "run-time typing" refer to two different approaches to type checking in programming languages.
1. **Compile-time typing**: In languages with compile-time typing, type checking is performed by the compiler during the compilation phase. This means that the compiler verifies the types of variables, expressions, and function parameters statically, before the program is executed. If any type errors are found during compilation, such as assigning a value of the wrong type to a variable or passing an argument of the wrong type to a function, the compiler will generate an error or warning message. Examples of languages with compile-time typing include Java, C, and C++.

   Compile-time typing offers the advantage of catching type errors early in the development process, before the program is run. This can help prevent certain classes of bugs and improve code reliability. However, it can also be more restrictive, as the programmer needs to specify types explicitly, and certain dynamic behaviors may be harder to express.

2. **Run-time typing**: In languages with run-time typing, type checking is deferred until the program is actually executed. This means that type information is associated with values at runtime, and type checking is performed dynamically as the program runs. If a type error occurs during execution, such as attempting to perform an operation on values of incompatible types, an error may be raised or the program may exhibit unexpected behavior. Examples of languages with run-time typing include Python, JavaScript, and Ruby.

   Run-time typing offers the advantage of greater flexibility and expressiveness, as variables and data structures can change types dynamically during program execution. This can make code more concise and easier to write in certain situations. However, run-time typing can also lead to a higher risk of type-related errors that may only manifest during execution, as well as potentially slower performance due to the overhead of dynamic type checking.

In summary, the choice between compile-time typing and run-time typing depends on factors such as the programming language, the requirements of the application, and the preferences of the development team. Both approaches have their own trade-offs in terms of safety, flexibility, and performance.


a2->

In Java, the "runtime type" and "compile-time type" refer to two different aspects of an object or expression:

1. **Compile-time type**: This refers to the type of a variable or expression as determined by the compiler at compile time. It is the declared type of the variable or expression as written in the code.

2. **Runtime type**: This refers to the actual type of the object that a variable or expression references during program execution. It is determined dynamically at runtime based on the actual object being referred to, which may be a subtype of the compile-time type.

Let's illustrate the difference with an example:

            ```java
            class Animal {
                public void makeSound() {
                    System.out.println("Animal makes a sound");
                }
            }

            class Dog extends Animal {
                @Override
                public void makeSound() {
                    System.out.println("Dog barks");
                }
            }

            class Cat extends Animal {
                @Override
                public void makeSound() {
                    System.out.println("Cat meows");
                }
            }

            public class Main {
                public static void main(String[] args) {
                    Animal animal1 = new Dog(); // Compile-time type: Animal, Runtime type: Dog
                    Animal animal2 = new Cat(); // Compile-time type: Animal, Runtime type: Cat

                    // Compile-time type determines what methods can be called
                    animal1.makeSound(); // Output: Dog barks
                    animal2.makeSound(); // Output: Cat meows

                    // Runtime type determines which overridden method is actually executed
                }
            }
            ```

In this example, we have three classes: `Animal`, `Dog`, and `Cat`. Both `Dog` and `Cat` are subclasses of `Animal`, and they override the `makeSound()` method.

In the `main` method, we create instances of `Dog` and `Cat` and assign them to variables of type `Animal`. At compile time, the compiler sees these variables as of type `Animal`, which means it only allows access to methods declared in the `Animal` class.

However, at runtime, the actual type of the objects (`Dog` or `Cat`) is determined. When the `makeSound()` method is called on these objects, the JVM looks at the runtime type of the objects and executes the overridden version of the method accordingly. This demonstrates the difference between compile-time type and runtime type in Java.
 */
