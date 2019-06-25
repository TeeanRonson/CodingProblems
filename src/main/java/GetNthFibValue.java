public class GetNthFibValue {


    public static int getNthFib(int n) {


        int[] values = new int[2];
        values[0] = 0;
        values[1] = 1;

        for (int i = 0; i < n - 2; i++) {
            int dummy = values[0] + values[1];
            values[0] = values[1];
            values[1] = dummy;
        }

        return values[1];

    }

    public static void main(String[] arg) {

        System.out.println(getNthFib(3));
        System.out.println(getNthFib(4));
        System.out.println(getNthFib(5));
        System.out.println(getNthFib(6));
        System.out.println(getNthFib(7));


    }
}
