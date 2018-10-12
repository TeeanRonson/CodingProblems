package DecoratorPattern;

public class TomatoSauce extends Toppings {


    public TomatoSauce(Pizza newPizza) {
        super(newPizza);
    }

    public String getDescription() {
        return this.tempPizza.getDescription() + ", TomatoSauce";
    }

    public double getCost() {
        return this.tempPizza.getCost() + 0.25;
    }
}
