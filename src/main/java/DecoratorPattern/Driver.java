package DecoratorPattern;

public class Driver {


    public static void main(String[] args) {


        Pizza pizza1 = new TomatoSauce(new Mozarella(new PlainPizza()));

        System.out.println(pizza1.getDescription());

        System.out.println(pizza1.getCost());


    }
}
