import java.util.Scanner;

public class Car {
    private final String description;
    public Car(String description){
        this.description = description;
    }
    public void startEngine(){
        System.out.printf("Car Engine with type %s  has Started. %n ",this.getClass().getSimpleName());
    }
    public void drive(){
        System.out.println("Car Ready to Drive");
        runEngine();
    }
    protected void runEngine(){
        System.out.println("Car Engine is Running");

    }
    public static Car getCar(String Type, String Name){
        return switch(Type){
            case "GPC","gpc","gc","GasPoweredCar" -> new GasPoweredCar(Name);
            case "EC","ec","Ec","ElectricCar" -> new ElectricCar(Name);
            case "HC","hc","HybridCar" -> new HybridCar(Name);
            default -> new Car(Name);
        };
    }
    public void SettingValues(){
        Scanner sc = new Scanner(System.in);
        if(this instanceof GasPoweredCar){

            System.out.println("Enter Gas Powered Car Data");
            System.out.print("Cylinders: ");
            ((GasPoweredCar) this).setCylinders(sc.nextInt());
            System.out.print("Average KM per Litre: ");
            ((GasPoweredCar) this).setAvgKmPerLitre(sc.nextDouble());

        } else if (this instanceof ElectricCar) {

            System.out.println("Enter Electric Powered Car Data");
            System.out.print("Battery Size: ");
            ((ElectricCar) this).setBatterySize(sc.nextInt());
            System.out.print("Average KM per Charge: ");
            ((ElectricCar) this).setAvgKmPerCharge(sc.nextDouble());

        } else if (this instanceof  HybridCar) {
            System.out.println("Enter Hybrid Car Data");
            System.out.print("Cylinders: ");
            ((HybridCar) this).setCylinders(sc.nextInt());
            System.out.print("Battery Size: ");
            ((HybridCar) this).setBatterySize(sc.nextInt());
            System.out.print("Average KM per Litre: ");
            ((HybridCar) this).setAvgKmPerLitre(sc.nextDouble()
            );
        }
    }
    public String getDescription() {
        return description;
    }
}
