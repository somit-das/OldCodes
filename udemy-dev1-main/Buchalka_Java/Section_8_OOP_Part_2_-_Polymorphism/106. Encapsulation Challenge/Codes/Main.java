public class Main {
    public static void main(String[] args) {
        Printer p1 = new Printer(100, true);
        Printer p2 = new Printer(100, false);

        System.out.println("Initial pages printed for printer 1 = " + p1.getPagesPrinted());
        System.out.println("Initial pages printed for printer 2 = " + p2.getPagesPrinted());

        p1.printPages(5);
        p1.printPages(19);
        p1.printPages(57);
        p1.printPages(300);
        p1.printPages(300);
        p1.printPages(300);
        p1.printPages(300);
        p1.printPages(300);
        p1.addToner(300);
        p1.printPages(300); p1.printPages(300);
        p1.printPages(300);
        p1.printPages(300);
        p1.addToner(300);
        System.out.printf("Current Job Pages: %d ,Final(Total) pages printed = %d",p1.printPages(20), p1.getPagesPrinted());



    }
}
