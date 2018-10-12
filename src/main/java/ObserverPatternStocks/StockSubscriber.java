package ObserverPatternStocks;

public class StockSubscriber implements Observer {

    private double ibmPrice;
    private double applPrice;
    private double googlPrice;

    private static int observerIdTracker = 0;

    private int observerId;
    private Publisher stockGrabber;

    public StockSubscriber(StockGrabber grabber) {
        this.stockGrabber = grabber;
        this.observerId = ++observerIdTracker;

        System.out.println("Observer Id: " + observerId);

        stockGrabber.register(this);
    }


    @Override
    public void update(double ibmPrice, double applPrice, double googlPrice) {

        this.ibmPrice = ibmPrice;
        this.applPrice = applPrice;
        this.googlPrice = googlPrice;

        printPrices();
    }

    private void printPrices() {
        System.out.println("IBM:" + this.ibmPrice);
        System.out.println("APPLE: " + this.applPrice);
        System.out.println("GOOGLE: " + this.googlPrice);
    }


    public static void main(String[] args) {


        StockGrabber grabber = new StockGrabber();

        StockSubscriber subscriber1 = new StockSubscriber(grabber);

        grabber.setIbm(150.0);
        System.out.println();
        grabber.setAppl(300.00);
        System.out.println();
        grabber.setGoogl(1200);
        System.out.println();


        System.out.println("**********************************************************************");
        StockSubscriber subscriber2 = new StockSubscriber(grabber);

        grabber.setIbm(150.0);
        System.out.println();
        grabber.setAppl(300.00);
        System.out.println();
        grabber.setGoogl(1200);
        System.out.println();





    }
}
