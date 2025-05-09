public class Main {
    public static void main(String[] args) {

        EnhancedPlayer sd = new EnhancedPlayer("TIM");
        System.out.println("Initial health is "+ sd.healthRemaining());

        EnhancedPlayer sd2 = new EnhancedPlayer("TIM2",200,"Stick");
        System.out.println("Initial health is "+ sd2.healthRemaining());
    }
}
/*
        The Problems when class aren't properly encapsulated
            Allowing direct access to data on an object,can bypass checks and operations.

            It encourages an interdependency or coupling between the calling code  and the class.

            in Previous not enhanced code , if we change the field name in playerclass it will broke the calling code.

            Calling Code had to take on ther responsibility for properly initializing a new Player.
 */
/*
        Benefits of Encapsulation
            It's onle of the huge benefits of encapsulation , that is you are not actually affecting any other code.
            It's sort of like a black box in manyways. What we're saying here is, the only way  to create an enhanced player object, is to call the constructor with these parameters.And we've also got some rules in there for what health can be. But the other thing is we can't bypass the EnhancedPlayer's method, and change the health field directly. We haven't provided a mechanism to change the health by any other means, except to use the methods, loseHealth, or restoreHealth. We can pass the initial amount of health in the constructor, but we can't change it after that, like we did in the other class. Using the Player class, we could set the value, and we actually changed the value midpoint when we shouldn't have. But the EnhancedPlayer class has more control over it's data.


            This why we use encapsulation We really want to protect access to our object's data. We protect the members of the class, and some methods, from external access. This prevents calling code from bypassing the rules and constraints, we've built into the class. In this case, as I said, we're using it to make sure that the enhanced player, When we create a new instance, it's initialized with valid data. But likewise, we're also making sure that there's no direct access to the fields.



 */
