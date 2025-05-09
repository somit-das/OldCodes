public class Main {
    public static void main(String[] args) {
        Car car = new Car("2022 Blue Ferrari 296 GTS");
        runRace(car);

        System.out.println();

        Car ferrari = new GasPoweredCar("2022 Blue Ferrari 296 GTS",15.6,6);
        runRace(ferrari);

        System.out.println();

        Car tesla = new ElectricCar("2022 Red Tesla Model 3",568,75);
        runRace(tesla);

        System.out.println();

        Car ferrariHybrid = new HybridCar("2022 Black Ferrari SF90 Stradale",16,8,8);
        runRace(ferrariHybrid);

        System.out.println();
//        User Input
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
