public class NthFib {



    public static int fib(int n) {


        if (n == 1) return 0;
        if (n == 2) return 1;
        int[] mem = new int[n + 1];
        mem[1] = 0;
        mem[2] = 1;

        for (int i = 3; i <= n; i++) {
            mem[i] = mem[i-1] + mem[i-2];
        }
        return mem[n];
    }


    public static void main(String[] args) {


        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(5));
    }
}
