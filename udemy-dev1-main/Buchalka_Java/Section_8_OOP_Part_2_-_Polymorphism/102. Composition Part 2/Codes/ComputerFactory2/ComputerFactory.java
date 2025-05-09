public class ComputerFactory {
    public static void main(String[] args) {
//        Individual Component
        Monitor theMonitor = new Monitor("27 inch AOOC", "Acer","1920 x 1080");
        Motherboard theMotherboard = new Motherboard(" MSI PRO B650M-Micro-ATX ", "MSI",4 ,4,"AM-2.4");
        ComputerCase theCase = new ComputerCase("2208","Dell","240");

        System.out.println("-----------------------------------------");
        System.out.println(" The Personal Computer 0" + "\n==============");
        System.out.println();
        System.out.println();
//      pc0 product
        PersonalComputer thePC0 = new PersonalComputer("4556","SD",theMonitor,theMotherboard,theCase);
		System.out.println("the Personal Computer has Monitor of " + thePC0.getMonitor()+ " , motherboard of  "+ thePC0.getMotherboard() + " with computer case "+ thePC0.getComputercase());
		System.out.println();
		thePC0.getComputercase().pressPowerButton();
		thePC0.getMotherboard().loadProgram("Linux");
		thePC0.getMonitor().drawPixelAt(30,40,"aqua");
		System.out.println();
        System.out.println();
        System.out.println("-----------------------------------------");

//      pc1 product
        PersonalComputer thePC1 = new PersonalComputer("sd pc V1","SD",new Monitor("2k 91 ", "Benq","2540 x 1440"),new Motherboard(" MSI PRO B650M-Micro-ATX ", "MSI",4 ,4,"AM-2.4"),new ComputerCase("658","MSI","850"));
      
      
        System.out.println();
        System.out.println();
        System.out.println("#########################################");
        System.out.println(" The Personal Computer 1" + "\n==============");
        System.out.println();
        System.out.println();
        System.out.println("the Personal Computer has Monitor of " + thePC1.getMonitor()+ " , motherboard of  "+ thePC1.getMotherboard() + " with computer case "+ thePC1.getComputercase());
		//thePC1.getComputercase().pressPowerButton();
        //thePC1.getMotherboard().loadProgram("Windows");
        //thePC1.getMonitor().drawPixelAt(30,40,"red");
        thePC1.powerUp();
		thePC1.getMotherboard().loadProgram("Windows");
        System.out.println();
        System.out.println();
        System.out.println("#########################################");
    }

}

/*
    As a general rule when you are designing your programs in java , you probably want to look at composition first.

    Most of the experts will tell you , that as a rull look at using composition before implementing inheritance.

    Here all of products the parts made up the finished product and the finished product itself were able to inherit a set of attributes like model and manufacturer from product class.

    The calling code didn't have to know anything about those parts to get personal computer to do something. it was able to tell the personal computer to power up and the personal computer delegated that work to its parts.

    The reason composition is prefrerred over inheritance :
    -------------------------------------------------------
        . Composition is more flexible . You can add parts in or remove them and these changes are less likely to have a downstream effect.

        . Composition provides functional reuse outside of the class hierarchy meaning classes can share attributes & behavior by having similar components, instead of inheriting functionality from a parent or base class.

        . Java's inheritance breaks encapsulation , because subclasses may need direct access to a parent's state or behavior.  (
        Here are some ways in which inheritance can potentially lead to violations of encapsulation if not used carefully:
            Subclass Access to Superclass Members: In Java, subclasses inherit the accessible members (fields and methods) of their superclass. This means that subclasses have direct access to the superclass's members, even if they are intended to be private. Subclasses can access and modify these members, potentially bypassing encapsulation.

            Protected Members: Protected members of a superclass are accessible to subclasses. While this allows for controlled access to superclass members within subclasses, it can also lead to subclasses accessing and modifying data that should be encapsulated.

            Overriding Methods: Subclasses can override methods defined in their superclass. If a subclass overrides a superclass method that should not be overridden, it can change the behavior of the superclass in unexpected ways, potentially violating encapsulation.

            Fragile Base Class Problem: Inheritance can lead to the fragile base class problem, where changes to a superclass can have unintended consequences on its subclasses. For example, if a superclass changes its implementation details, it may inadvertently break subclasses that rely on those details, leading to encapsulation violations.)

     Why Inheritance is less flexible ?
     -----------------------------------

        . Inheritance is less flexible .

        . Adding a class to or removing a class from , a class hierarchy , may impact all subclasses from that point.

        . In addition a new subclass may not need all the functionality or attributes of its parent class and therefore adding subclass will muddy the waters meaning  the model no longer represents the reality in the code.
        for example if we try to add digital product class to this current program .
        if we use inheritance to make it inherit the properties from productparts class then it would be a disaster as height ,width , depth and model does not make any sense for non-physical object as digital product item exists in software world where size(width,height,depth) doesn't work. To fight this scenario we will not inherit the class from productparts or else we decompose productpart class into 2 classes that is Product
 */