public class Printer {

    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {

        if(tonerLevel < 0){
            this.tonerLevel = 0;
        }else if (tonerLevel > 100){
            tonerLevel = 100;
        }else {
            this.tonerLevel = tonerLevel;
        }

        this.duplex = duplex;
    }

    public int addToner(int tonerAmount){

        this.tonerLevel += tonerAmount;

        if (this.tonerLevel > 100 || this.tonerLevel < 0){
            return -1;
        }

        return this.tonerLevel;
    }

    public int printPages(int pages){

        int jobPages = (duplex) ? (pages / 2) + (pages % 2) : pages;
        pagesPrinted += jobPages;
        return jobPages;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}
