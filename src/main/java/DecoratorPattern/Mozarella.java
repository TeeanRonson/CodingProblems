package DecoratorPattern;

public class Mozarella extends Toppings {


    public Mozarella(Pizza newPizza) {
        super(newPizza);
    }

    public String getDescription() {
        return this.tempPizza.getDescription() + ", Mozarella";
    }

    public double getCost() {
        return this.tempPizza.getCost() + 0.5;
    }
}
