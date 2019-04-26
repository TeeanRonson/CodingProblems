public class ReverseInteger {

    public static int reverse(int x) {

        int result = 0;

        while (x != 0) {
            int digit = x % 10;
            result = result * 10 + digit;
            x = x / 10;
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) result;
    }


    public static void main(String[] args) {

        int x = 123;
        int y = -123;
        int z = 120;

        System.out.println(reverse(x));
        System.out.println(reverse(y));
        System.out.println(reverse(z));



    }
}
