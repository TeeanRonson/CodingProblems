import java.lang.reflect.Array;
import java.util.ArrayList;


public class ProductSum {

    public static int productSum(ArrayList<Object> array) {

        return findTotalSum(array, 1);
    }

    public static int findTotalSum(ArrayList<Object> array, int multiplier) {

        System.out.println(multiplier);
        int sum = 0;
        for (Object x: array) {
            if (x instanceof ArrayList) {
                sum += findTotalSum((ArrayList) x, multiplier+1);
            } else {
                sum += (int) x;
            }
        }
        return sum * multiplier;
    }

    public static void addTwo(int x) {
        x += 2;

    }


    public static void main(String[] args) {


//        ArrayList<Object> one = new ArrayList<>();
//        one.add(5);
//        ArrayList<Object> two = new ArrayList<>();
//        two.add(1);
//        two.add(3);
//
//        one.add(two);
//
//        System.out.println(productSum(one));



        boolean[] test = new boolean[2];

        for (boolean x: test) {
            System.out.println(x);
        }

        int x = 5;

        addTwo(x);
        System.out.println(x);


    }
}

