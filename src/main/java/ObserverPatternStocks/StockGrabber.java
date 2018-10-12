package ObserverPatternStocks;

import java.util.ArrayList;

public class StockGrabber implements Publisher {


    private ArrayList<Observer> observers;
    private double ibm;
    private double appl;
    private double googl;

    public StockGrabber() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer newObserver) {

        observers.add(newObserver);

    }

    @Override
    public void unregister(Observer o) {

        int observerIndex = observers.indexOf(o);



        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver() {

        for (Observer o: observers) {
            o.update(this.ibm, this.appl, this.googl);
        }
    }


    public void setIbm(double newPrice) {

        this.ibm = newPrice;
        notifyObserver();

    }

    public void setAppl(double newPrice) {

        this.appl = newPrice;
        notifyObserver();

    }
    public void setGoogl(double newPrice) {

        this.googl = newPrice;
        notifyObserver();

    }


}
