import java.awt.*;

public class VarMain {
    public static void main(String[] args) {
        var threeIdiots = Movie.getMovie("C","3 Idiots");
        threeIdiots.watchMovie();
/*
        This code compiles, but here is something new. We haven't used this before, and you're probably  asking, what is this var word mean?

            Well, var, is a special contextual keyword in java that lets our code take advantage of Local variable Type Inference.

            By using var as the type , we're telling java to figure out the compile-time type for us.

        here in above code that we are returning Movie class was declared as the return type of the static method getMovie , then Java can infer that type of this variable , threeIdiots should be  Movie.

        Now why didn't it infer that it was a Comedy class? Nothing about the signature of the method,  indicated that a Comedy instance might be returned, from the method. Only that a Movie would be.

 */
         var GolMaal =  new Comedy("GolMaal");
         GolMaal.watchComedy();

         /*
             In this case, the compiler had an easier job, to infer the type, because we're simply assigning  a new instance of Comedy to this variable, GolMaal. But you can see now, that using this GolMaal  variable, we can execute methods, specific to Comedy, without compile time errors.
          */

    }
}
/*
         Local Variable Type Inference was introduced in Java 10. One of the benefits is to help with the readability of the code and to reduce boilerplate code. It's called Local variable type inference for a reason because :

                    It can't be used in field declarations on a class.

                    It can't be used in method signatures , either as parameter type or a return type.

                    It can't be used without an assignment, because  the type can't be inferred in that case.

                    It can't be assigned a null literal, again  because a type can't be inferred in that case.
 */

/*
?. In many cases the compile time type is the declared type to the left of the assignment operator. Verify It's True or not

a->

Yes, in many statically typed languages, especially those with type inference capabilities, the compile-time type is often inferred from the declared type of the variable to the left of the assignment operator. This process is known as type inference.

For example, in languages like Java, C#, and Swift, you can declare a variable without explicitly specifying its type using the `var` keyword (in C# and Swift) or using type inference in variable declarations (in Java):

In Java:
```java
var myVar = "Hello, world!";
```

In C#:
```csharp
var myVar = "Hello, world!";
```

In Swift:
```swift
var myVar = "Hello, world!"
```

In these examples, the compiler infers the type of `myVar` based on the type of the value assigned to it (`String` in this case). The inferred type becomes the compile-time type for `myVar`.

However, even when type inference is not explicitly used, the compile-time type is determined based on the declared type of the variable:

```java
String myString = "Hello, world!";
```

In this Java example, the compile-time type of `myString` is explicitly declared as `String`.

This compile-time type information is then used by the compiler for type checking and optimization purposes, ensuring type safety and efficient code generation.

 */
/*
You can assign a runtime instance, to a different compile time type,  How is that possible ?

a1->
    Yes, you can assign a runtime instance to a variable of a different compile-time type under certain conditions, depending on the programming language and its type system. This is often referred to as type casting or type conversion.

Here's how it works in various languages:

1. **Java**:
   ```java
   Object obj = "Hello, world!";
   String str = (String) obj; // Explicit casting
   ```

2. **C#**:
   ```csharp
   object obj = "Hello, world!";
   string str = (string) obj; // Explicit casting
   ```

3. **Python**:
   ```python
   obj = "Hello, world!"
   str = str(obj) # Explicit conversion using str() function
   ```

In these examples, a value of one type (`String` in the first two examples, and any type in the Python example) is assigned to a variable of a different type (`Object` or `object` in the first two examples, and `str` in the Python example). To perform this assignment, an explicit cast or conversion is required to inform the compiler or interpreter about the intended type.

It's important to note that while you can perform such type conversions, they may not always be safe. If the runtime instance's type is not compatible with the target compile-time type, the conversion may fail at runtime, leading to exceptions or unexpected behavior. Therefore, it's essential to ensure that such conversions are valid and handle any potential errors appropriately. Additionally, excessive or unnecessary type conversions can indicate design flaws in your code and should be used judiciously.

a2->
    Yes, you can assign a runtime instance to a different compile-time type in languages that support polymorphism or type casting. This is often done through inheritance or interface implementation, allowing you to treat objects of subclasses or implementations as instances of their superclass or interface types.

Here's how it typically works:

1. **Polymorphism**: If an object is an instance of a subclass, you can assign it to a variable of its superclass type. This is safe because the subclass inherits all the properties and behaviors of its superclass.

```java
class Animal {  }
class Dog extends Animal {  }

Dog myDog = new Dog();
Animal myAnimal = myDog; // Assigning a Dog instance to an Animal variable
   ```
2. **Type Casting**: In some cases, you might need to explicitly cast an object to a different type if it's safe to do so. This is known as type casting.

```java
class Animal { }
class Dog extends Animal {  }

Animal myAnimal = new Dog();
Dog myDog = (Dog) myAnimal; // Explicit casting from Animal to Dog
```

It's important to note that if the runtime type of the object being casted is not compatible with the target type, a `ClassCastException` may occur at runtime. So, you should use type casting cautiously and ensure type safety.

3. **Interfaces**: Similarly, you can assign instances of classes implementing an interface to variables of the interface type.

```java
interface Shape {  }
class Circle implements Shape {  }

Circle myCircle = new Circle();
Shape myShape = myCircle; // Assigning a Circle instance to a Shape variable
```

By allowing assignment of runtime instances to different compile-time types, these language features promote flexibility, polymorphism, and code reuse in object-oriented programming. However, it's crucial to understand the relationships between types and ensure type safety to prevent runtime errors.
 */