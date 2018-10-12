package ObserverPatternStocks;

public interface Publisher {


    public void register(Observer o);

    public void unregister(Observer o);

    public void notifyObserver();
}
