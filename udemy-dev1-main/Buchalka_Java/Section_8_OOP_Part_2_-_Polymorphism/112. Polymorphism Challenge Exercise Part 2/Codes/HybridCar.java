

public class HybridCar extends Car{
    private double avgKmPerLitre;
    private int batterySize;
    private int cylinders;

    public HybridCar(String description) {
        super(description);
    }

    public HybridCar(String Description, double avgKmPerLitre, int batterySize, int cylinders){
        super(Description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.batterySize = batterySize;
        this.cylinders = cylinders;
    }


    public void setAvgKmPerLitre(double avgKmPerLitre) {
        this.avgKmPerLitre = avgKmPerLitre;
    }


    public void setBatterySize(int batterySize) {
        this.batterySize = batterySize;
    }


    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }
    @Override
    public void startEngine() {
        System.out.printf("%s : %s with %d battery size and  %d cylinders are fired up %n",this.getClass().getSimpleName(),this.getDescription(),batterySize,cylinders);
    }

    @Override
    protected void runEngine() {
        System.out.printf("%s : %s with %.2f km as milage is running %n", this.getClass().getSimpleName(),this.getDescription(),avgKmPerLitre);
    }

}
