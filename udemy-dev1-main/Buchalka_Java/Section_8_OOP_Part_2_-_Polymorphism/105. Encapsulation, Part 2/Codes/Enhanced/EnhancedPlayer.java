public class EnhancedPlayer {
//    public String name;
//    public int health;
//    public String weapon;
    private String name;
    private int health;
    private String weapon;

    public EnhancedPlayer(String name) {
//        this.name = name;
        this(name,100,"Sword");
    }

    public EnhancedPlayer(String name, int health, String weapon) {
        this.name = name;
        this.health = health;
        if(health<=0){
            this.health = 1;
        } else if (health > 100) {
            this.health = 100;
        } else{
            this.health = health;
        }
        this.weapon = weapon;
    }

    public void loseHealth(int damage){
        health  = health - damage;
        if(health<=0){
            health = 0;
            System.out.println("Player Knocked out of game");
        }
    }
    public int healthRemaining(){
        return health;
    }
    public void restoreHealth(int extraHealth){
        health = health + extraHealth;
        if(health>100){
            health = 100;
            System.out.println("Player restored to 100%");
        }
    }
}
/*
       Encapsulation Principles
            To create an encapsulated class you want to
                create constructors for object initialization which enforces only objects with valid data will get created.

                Use the private access modifier for your fields .

                Use setter and getter methods sparingly and only as needed.

                Use access modifiers that aren't private , only for methods that the calling code needs to use.

 */