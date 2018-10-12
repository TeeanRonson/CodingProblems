package VisitorPattern;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

public class Driver {

    public static void main(String[] args) {

        DiscountDay dd = new DiscountDay();

        Milk item1 = new Milk(4.00);
        Tshirt item2 = new Tshirt(100.00);

        System.out.println("Milk price on discount: " + item1.accept(dd));

        System.out.println("T shirt price on discount: " + item2.accept(dd));
    }
}
