public class Holden extends Car {
    // write code here
    public Holden(int cylinders,String name){
        super(cylinders,name);
    }
    // public void startEngine(){
    //     System.out.println("Holden -> startEngine()");
    // }
    // public void accelerate(){
    //     System.out.println("Holden -> accelerate()");
    // }
    // public void brake(){
    //     System.out.println("Holden -> brake()");
    // }
    
    public String startEngine(){
        return "Holden -> startEngine()";
    }
    public String accelerate(){
        return "Holden -> accelerate()";
    }
    public String brake(){
        return "Holden -> brake()";
    }
}
