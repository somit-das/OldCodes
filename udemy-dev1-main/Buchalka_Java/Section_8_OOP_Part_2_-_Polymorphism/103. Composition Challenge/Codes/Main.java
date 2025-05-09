public class Main {
    public static void main(String[] args) {
        SmartKitchen s1 = new SmartKitchen();
        boolean coffeebrewNow = true;
        boolean dodishNow = true;
        boolean doOrder = false;
        s1.doKitchenWork();
        s1.setKitchenState(coffeebrewNow,dodishNow,doOrder);
        s1.doKitchenWork();

    }
}
