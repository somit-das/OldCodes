public class CoffeeMaker extends  ApplianceFunction{


    public void brewCoffee(){
        if(getHasWorkTodo()){
            System.out.println("Work (Brewing Coffee) is being done.");
        }
        else{
            System.out.println("Can't Work right Now.");
        }
    }
}
