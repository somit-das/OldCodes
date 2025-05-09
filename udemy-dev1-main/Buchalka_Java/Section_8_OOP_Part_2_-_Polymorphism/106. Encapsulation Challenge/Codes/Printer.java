public class Printer {
    private double tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    Printer(double tonerLevel, boolean duplex) {
        this.tonerLevel = tonerLevel;
//        this.pagesPrinted = pagesPrinted;
        this.duplex = duplex;
    }
    public int getPagesPrinted(){
        return pagesPrinted;
    }

    public double addToner(double tonerAmount){
        if (tonerLevel==100.0){
            System.out.println("No need to add tonerLevel");
            return 0;
        }
        else if(tonerAmount>0 && tonerAmount<=100){
//            tonerLevel += tonerAmount;
            double needTonerLevel = 100 - tonerLevel;
            if(needTonerLevel<tonerAmount){
                System.out.printf("\nRemaining TonerAmount %f returned to you\n", tonerAmount-needTonerLevel);
                tonerLevel = 100;
                return tonerAmount-needTonerLevel;
            } else if (needTonerLevel == tonerAmount) {
                tonerLevel = 100;
                System.out.println(" All toner Amount got used");
                return 0;
            } else{
                System.out.printf("\nMore Toner Amount : %f required\n",needTonerLevel-tonerAmount);
                tonerLevel+= tonerAmount;
                return  -1;
            }
        } else if (tonerAmount > 100) {

            double needTonerLevel = 100 - tonerLevel;
            if(needTonerLevel<tonerAmount){
                System.out.printf(" \nRemaining TonerAmount %f returned to you\n", tonerAmount-needTonerLevel);
                tonerLevel = 100;
                return tonerAmount-needTonerLevel;
            } else if (needTonerLevel == tonerAmount) {
                tonerLevel = 100;
                System.out.println(" All toner Amount got used");
                return 0;
            } else{
                System.out.printf(" \nMore Toner Amount : %f required\n",needTonerLevel-tonerAmount);
                tonerLevel+= tonerAmount;
                return  -1;
            }
        }

        else{
            return  -1;
        }
    }
    public int printPages(int pages){
        if(tonerLevel<1){
//            pagesPrinted = 0;
            System.out.println("Sorry Toner Level is gone case");
            System.out.println("Can't print more");
            System.out.println("Add Toner Level");
            return 0;
        }
        if(pages>0){
            int jobpages;
            if(duplex){
                jobpages = pages/2 + pages%2;
//                pagesPrinted += jobpages;
                System.out.println("We have to print "+ jobpages + "pages");
                pagesPrinted += jobpages;
                System.out.println("Job Pages: "+ pagesPrinted);
                tonerLevel = tonerLevel - 0.25*jobpages;

                if(tonerLevel <= 0){
                    tonerLevel = 0;
                    System.out.println("Add More Toner Level to Print More pages");
                }
                return jobpages;

            }
            else{
                jobpages = pages;
//                pagesPrinted += jobpages;
                System.out.println("We have to print "+ jobpages + "sheets");
                pagesPrinted += jobpages;
                System.out.println("Job Pages: "+ pagesPrinted);
                tonerLevel = tonerLevel - 0.25*jobpages;

                if(tonerLevel <= 0){
                    tonerLevel = 0;
                    System.out.println("Add More Toner Level to Print More pages");
                }
                return pages;
            }
        }
        else {
            return -1;
        }
    }

}
