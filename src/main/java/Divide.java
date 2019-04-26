public class Divide {


        public static int divide(int dividend, int divisor) {

            boolean negative = false;
            int count = 0;
            int absDivid = Math.abs(dividend);
            int absDivis = Math.abs(divisor);


            if (dividend < 0 || divisor < 0) {
                negative = true;
            }
            if (dividend < 0 && divisor < 0) {
                negative = false;
            }


            while (absDivid - absDivis >= 0) {
                absDivid -= absDivis;
                count++;
            }

            if (negative == true) {
                return -count;
            } else {
                return count;
            }

        }


    public static void main(String[] args) {

        divide( -2147483648, -1);

    }
}
