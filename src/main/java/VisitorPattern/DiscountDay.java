package VisitorPattern;

public class DiscountDay implements Visitor {


    @Override
    public double visit(Milk item) {
        return (item.getPrice() * 0.8);
    }

    public double visit(Tshirt item) {
        return (item.getPrice() * 0.5);
    }
}
