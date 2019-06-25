

public class SquareRoot {


    public static float squareRoot(float n) {

        return squareRootHelp(n, n);
    }

    private static float squareRootHelp(float original, float n) {

//        if (n*n == original) {
//            return n;
//        }
//
//        if ((n/2) * (n/2) > original) {
//            return squareRootHelp(original, n/2);
//        } else {
//            return squareRootHelp(original, (float) ((n/2)*(1.5)));
//        }


        if (original == 0 || original == 1) {
            return original;
        }

        int x = 1, result = 1;

        while (result <= original) {
            x++;
            result = x * x;
        }

        return x-1;

    }


    public static void main(String[] args) {

        float result = squareRoot(400);

        System.out.println(result);
    }
}
