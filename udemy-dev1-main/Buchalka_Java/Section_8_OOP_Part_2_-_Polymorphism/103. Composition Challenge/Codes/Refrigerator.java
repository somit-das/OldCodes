public class Refrigerator extends ApplianceFunction{
    public void orderFood(){
        if(getHasWorkTodo()){
            System.out.println("Work (order Food) is being done.");
        }
        else{
            System.out.println("Can't do order food right Now.");
        }
    }

}
