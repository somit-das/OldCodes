public class ElectricCar extends Car{
    private  double avgKmPerCharge;
    private  int batterySize;
    public ElectricCar(String description) {
        super(description);
    }

//    public ElectricCar(String Description,double avgKmPerCharge,int batterySize){
//        super(Description);
//        this.avgKmPerCharge = avgKmPerCharge;
//        this.batterySize = batterySize;
//
//    }

    public void setAvgKmPerCharge(double avgKmPerCharge) {
        this.avgKmPerCharge = avgKmPerCharge;
    }

    public void setBatterySize(int batterySize) {
        this.batterySize = batterySize;
    }

    @Override
    public void startEngine() {
        System.out.printf("%s : %s with %d battery size ready to run %n",this.getClass().getSimpleName(),this.getDescription(),batterySize);
    }

    @Override
    protected void runEngine() {
        System.out.printf("%s : %s with %.2f km as milage is running %n", this.getClass().getSimpleName(),this.getDescription(),avgKmPerCharge);
    }

}
