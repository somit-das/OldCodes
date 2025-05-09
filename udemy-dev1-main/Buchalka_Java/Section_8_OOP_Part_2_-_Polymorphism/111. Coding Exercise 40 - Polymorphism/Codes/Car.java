public class Car {
    // write code here
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels ;
    public Car(int cylinders,String name){
        this.cylinders = cylinders;
        this.name = name;
        this.wheels = 4;
        this.engine = true;
    }
    public String getName(){
        return name;
    }
    public int getCylinders(){
        return cylinders;
    }
    public String startEngine(){
        return "Car -> startEngine()";
    }
    public String accelerate(){
        return "Car -> accelerate()";
    }
    public String brake(){
        return "Car -> brake()";
    }
    
}