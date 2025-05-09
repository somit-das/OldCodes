public class PersonalComputer extends  ProductParts {
// here we added extends Product to this class too. Even though our personal computer has  a bunch of parts, it's still a product,  with all of product's attributes. You can use a combination of inheritance, and composition, to create your model

    private Monitor monitor;
    private Motherboard motherboard;
    private ComputerCase computercase;


    PersonalComputer(String model, String manufacturer) {
        super(model, manufacturer);
    }

    public PersonalComputer(String model, String manufacturer, Monitor monitor, Motherboard motherboard, ComputerCase computercase) {
        super(model, manufacturer);
        this.monitor = monitor;
        this.motherboard = motherboard;
        this.computercase = computercase;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public ComputerCase getComputercase() {
        return computercase;
    }
    private void drawLogo(){
        monitor.drawPixelAt(1200,50, "blue");
    }
    public void powerUp(){
        computercase.pressPowerButton();
        drawLogo();
    }
}
