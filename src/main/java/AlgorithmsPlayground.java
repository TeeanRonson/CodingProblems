package java.codingproblems.cs686;

public class AlgorithmsPlayground {

    private static int number;

    public AlgorithmsPlayground() {


    }
//    public static long f1(long x, long n) {
//
//
//        if (n==0) {
//            return 1;
//        } else {
//            return x * f1(x, n -1 );
//        }
//
//    }
//
//
//    public static int recursive3(int n) {
//
//        if (n == 0) {
//            return 1;
//        }
//
//        return recursive3(n - 1) + recursive3(n - 1);
//    }

    public void setNumber() {
        this.number = 4;
        System.out.println(this.number);
    }





    public static void main(String[] args) {

       new AlgorithmsPlayground().setNumber();


//        System.out.println(f1(5, 2));
//
//        System.out.println(recursive3(2));








    }

    public static abstract class Beverage {

        private int ounces;

        public Beverage(int ounces) {
            this.ounces = ounces;



        }


    }
}


