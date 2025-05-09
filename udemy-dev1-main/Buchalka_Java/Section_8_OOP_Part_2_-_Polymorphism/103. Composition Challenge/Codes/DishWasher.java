public class DishWasher extends ApplianceFunction{
    public void doDishes(){
        if(getHasWorkTodo()){
            System.out.println("Work (Dish Washing) is being done.");
        }
        else{
            System.out.println("Can't do dish right Now.");
        }
    }
}
