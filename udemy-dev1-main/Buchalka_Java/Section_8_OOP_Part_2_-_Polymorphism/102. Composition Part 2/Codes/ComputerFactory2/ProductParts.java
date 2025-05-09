public class ProductParts {
    private String model ;
    private String manufacturer;
    private int width;
    private int height;
    private int depth;
    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }

    ProductParts(String model, String manufacturer){
        this.model = model;
        this.manufacturer = manufacturer;
    }
}
class Monitor extends ProductParts {
    private int size;
    private String resolution;
    Monitor(int size,String model , String manufacturer){
        super(model, manufacturer);
        this.size = size;
    }
    public Monitor(String model, String manufacturer, String resolution){
        super(model, manufacturer);
        this.resolution = resolution;
    }
    public void drawPixelAt(int x ,int y, String color){
//        System.out.println("Monitor Screen is ON");
        System.out.println(" pixels Drawing with color "+ color + " at position x: "+ x + " ,y: "+ y + "  on monitor display");
    }


}
class Motherboard extends ProductParts {


    private int ramSlots;
    private int cardSlots;
    private String bios;
    public Motherboard(String model , String manufacturer){
        super(model, manufacturer);
    }
    public Motherboard(String model, String manufacturer, int ramSlots, int cardSlots, String bios) {
        this(model, manufacturer);
        this.ramSlots = ramSlots;
        this.cardSlots = cardSlots;
        this.bios = bios;
    }
    public void loadProgram(String programName){
        System.out.println("Program "+ programName + " is now loading ... ");
    }
}
class ComputerCase extends ProductParts {


    private String powerSupply;

    public ComputerCase(String model, String manufacturer, String powerSupply) {
        super(model, manufacturer);
        this.powerSupply = powerSupply;
    }
    public void pressPowerButton(){
        System.out.println("Power button pressed");
    }

}
// here monitor,motherboard , computercase all inherits from productparts by forming ISA relationship