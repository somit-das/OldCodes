public class Ford extends Car{
    // write code here
    public Ford(int cylinders,String name){
        super(cylinders,name);
    }
    // public void startEngine(){
    //     System.out.println("Ford -> startEngine()");
    // }
    // public void accelerate(){
    //     System.out.println("Ford -> accelerate()");
    // }
    // public void brake(){
    //     System.out.println("Ford -> brake()");
    // }
    public String startEngine(){
        return "Ford -> startEngine()";
    }
    public String accelerate(){
        return "Ford -> accelerate()";
    }
    public String brake(){
        return "Ford -> brake()";
    }
}