
public class ThreeLargestNums {

    public static int[] findThreeLargestNumbers(int[] array) {

        int[] result = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        return findHelper(array, result);
    }

    public static int[] findHelper(int[] array, int[] result) {

        for (int i = 0; i < array.length; i++) {
            sorter(result, array[i]);
        }
        return result;
    }

    public static void sorter(int[] result, int value) {

        int i = result.length - 1;
        while (i >= 0) {
            if (value >= result[i]) {
                System.out.println("here:" + result[i]);
                for (int j = 0; j < i; j++) {
                    result[j] = result[j+1];
                    System.out.println("--");
                }
                result[i] = value;
                System.out.println("Before break:" + result[i]);
                break;
            }
            i--;
        }
        for (int k = 0; k < result.length; k++) {
            System.out.print(result[k] + " ");
        }
        System.out.println();
        System.out.println(value);

    }

    public static void print(int[] result) {

        for (int i = 0; i < result.length; i++) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {

        findThreeLargestNumbers(new int[] {7, 8, 55});



    }
}
