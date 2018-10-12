package VisitorPattern;

public class Tshirt implements Visitable {

    private Double price;

    public Tshirt(Double price) {
        this.price = price;


    }

    public double getPrice() {
        return this.price;
    }



    @Override
    public double accept(Visitor visit) {
        return visit.visit(this);
    }
}
