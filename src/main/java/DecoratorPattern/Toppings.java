package DecoratorPattern;

public abstract class Toppings implements Pizza{


    protected Pizza tempPizza;

    public Toppings(Pizza newPizza) {
        this.tempPizza = newPizza;
    }

   public String getDescription() {
        return this.tempPizza.getDescription();
   }

   public double getCost() {
        return this.tempPizza.getCost();
   }





}
