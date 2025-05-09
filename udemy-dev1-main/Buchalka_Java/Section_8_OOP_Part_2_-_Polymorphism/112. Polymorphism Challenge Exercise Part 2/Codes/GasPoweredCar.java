public class GasPoweredCar extends  Car{
    private double avgKmPerLitre;
    private int cylinders;
    
    public GasPoweredCar(String Description){
        super(Description);
    }
    public GasPoweredCar(String Description,double avgKmPerLitre,int cylinders){
        super(Description);
        this.avgKmPerLitre = avgKmPerLitre;
        this.cylinders = cylinders;
    }

    public void setAvgKmPerLitre(double avgKmPerLitre) {
        this.avgKmPerLitre = avgKmPerLitre;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    @Override
    public void startEngine() {
        System.out.printf("%s : %s with %d cylinders are fired up %n",this.getClass().getSimpleName(),this.getDescription(),cylinders);
    }

    @Override
    protected void runEngine() {
        System.out.printf("%s : %s with %.2f km as milage is running %n", this.getClass().getSimpleName(),this.getDescription(),avgKmPerLitre);
    }
}
