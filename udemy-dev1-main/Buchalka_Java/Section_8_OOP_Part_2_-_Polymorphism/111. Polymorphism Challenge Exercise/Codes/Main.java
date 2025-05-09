public class Main {
    public static void main(String[] args) {
        EnterCar();

    }
    public static void EnterCar(){
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter a Car Type: ");
        String type = sc.nextLine();
        System.out.print("Enter Car Description:- ");
        String carName = sc.nextLine();
        Car c1 = Car.getCar(type, carName);
        c1.SettingValues();
        runRace(c1);
    }
    public static  void runRace(Car car){
        car.startEngine();
        car.drive();

    }
}
