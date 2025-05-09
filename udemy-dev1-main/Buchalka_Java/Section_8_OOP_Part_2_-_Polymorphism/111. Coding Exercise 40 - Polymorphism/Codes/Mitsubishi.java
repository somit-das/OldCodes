public class Mitsubishi extends Car{
    // write code here
    public Mitsubishi(int cylinders,String name){
        super(cylinders,name);
    }
    // public void startEngine(){
    //     System.out.println("Mitsubishi -> startEngine()");
    // }
    // public void accelerate(){
    //     System.out.println("Mitsubishi -> accelerate()");
    // }
    // public void brake(){
    //     System.out.println("Mitsubishi -> brake()");
    // }
    public String startEngine(){
        return "Mitsubishi -> startEngine()";
    }
    public String accelerate(){
        return "Mitsubishi -> accelerate()";
    }
    public String brake(){
        return "Mitsubishi -> brake()";
    }
}