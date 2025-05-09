public class SmartKitchen {
    private CoffeeMaker brewMaster;
    private DishWasher dishWasher;
    private Refrigerator iceBox ;

    public SmartKitchen(){
        brewMaster = new CoffeeMaker();
        dishWasher = new DishWasher();
        iceBox = new Refrigerator();
    }
    public void setKitchenState(boolean brew,boolean dish,boolean order){
        brewMaster.setHasWorkToDo(brew);
        dishWasher.setHasWorkToDo(dish);
        iceBox.setHasWorkToDo(order);

    }
    public void addWater(){
        brewMaster.setHasWorkToDo(true);
    }
    public void pourMilk(){
        iceBox.setHasWorkToDo(true);
    }
    public void loadDishWasher(){
        dishWasher.setHasWorkToDo(true);
    }
    public void doKitchenWork(){
        brewMaster.brewCoffee();
        dishWasher.doDishes();
        iceBox.orderFood();
    }

}
