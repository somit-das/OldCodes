public class Main {
    public static void main(String[] args) {
        Player player = new Player(); //we don't now have a constructor  to pass player data, when we create a new player. This means the calling code, needs to manually set the data in these fields.

        player.name = "Som";
        player.health = 20;
        player.weapon = "Sword";
/*
        Allowing direct access to data on object can potentially by pass checks and additional processing , your class has in place to manage the data. By being able to access fields directly like this, we're really potentially opening up our application, to be accessed in ways that it shouldn't be. Maybe we don't ever want the code to be able to  change the health like that, because we really wanted the restoreHealth method to be called,  and the right set of conditions to be set. But because these fields are public to everyone,  we can't control when they get accessed.


        anytime that we change this field's name, we have  to also make the change here in the Main class And in a small application like this of course, it's not going to be a problem. It's quite a quick change. But when you're talking about big applications, it does become a problem. Because the first thing here, looking at the Main class, you have to figure out  what's the new correct name of the field. This means you need to go back into the code,  and have a look and see what the new name is And maybe this isn't really a problem as much when  it's your own code, but if you're deploying this kind of code in a library for example, you're  setting yourself up for a lot of problems. So allowing direct access to fields, means  calling code would need to change,  when you edit any of the fields.




        The third issue with this approach is, we're manually initializing  our object with these calls at the start. This means the calling code is responsible for making all the right method calls, to  initialize a player, at the beginning of the play.  But the code might actually forget to initialize this all together.   And consequently, when the class is called for the first time, the player may be starting out with health = 0. In other words, we're not guaranteeing or ensuring that, to access the player class, we can only access it, when the data is valid. Now we can do that with a constructor. We can actually make sure that the data is valid, and that the object is valid before the game starts. But when you're allowing people to manually access the fields, there's no real way to guarantee that the player health is set. So Omitting a constructor, that would accept initialization data,   may mean the calling code is responsible  for setting up this data, on the new object and this is what encapsulation actually does  for us, and why we don't want to code like this. We want the ability to ensure certain conditions are met before playing, and that access to the player data during  the game, is controlled and protected.























 */
        int damage = 10;
        player.loseHealth(damage);
        System.out.println(" Remaining health = "+ player.healthRemaining());
        damage = 11;
        player.loseHealth(damage);
        System.out.println(" Remaining health = "+ player.healthRemaining());
    }
}
