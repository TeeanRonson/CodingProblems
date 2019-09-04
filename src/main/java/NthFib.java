public class NthFib {



//    public static int fib(int n) {
//
//
//        if (n == 1) return 0;
//        if (n == 2) return 1;
//        int[] mem = new int[n + 1];
//        mem[1] = 0;
//        mem[2] = 1;
//
//        for (int i = 3; i <= n; i++) {
//            mem[i] = mem[i-1] + mem[i-2];
//        }
//        return mem[n];
//    }

    public static int getNthFib(int n) {

        int[] db = new int[] {0, 1};
        int i = 0;

        while(i < n) {
            int sum = db[0] + db[1];
            db[0] = db[1];
            db[1] = sum;
            i++;
            print(db);
        }
        return db[0];
    }

    private static void print(int[] db) {

        for (int i: db) {
            System.out.print(i + " ");
        }
        System.out.println();
    }





    public static void main(String[] args) {


        System.out.println("Result: " + getNthFib(1));
        System.out.println("Result: " + getNthFib(2));
        System.out.println(getNthFib(5));
    }
}
