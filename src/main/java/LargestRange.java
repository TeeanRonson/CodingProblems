import java.util.Arrays;

class LargestRange {

    public static int[] largestRange(int[] array) {
        Arrays.sort(array);
        for (int k: array) {
            System.out.print(k + " ");
        }
        System.out.println();

        int max = Integer.MIN_VALUE;
        int length = 0;
        int i = 0, j = 1;
        int first = array[0];
        int[] result = new int[2];

        while (i < array.length && j < array.length) {
            if (array[j] == array[i] + 1 || array[j] == array[i]) {
                length++;
            } else {
                if (length >= max) {
                    max = length;
                    result = new int[] {first, array[i]};
                    first = array[j];
                }
                length = 0;
            }
            i++;
            j++;
        }

        if (length + 1 >= max) {
            result = new int[] {first, array[i]};
            printResult(result);
            return result;
        }

        printResult(result);
        return result;
    }


    public static void printResult(int[] array) {

        System.out.print("Result: ");
        for (int x: array) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {


        int[] array = new int[] {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6, 13, 14, 16, 17, 18, 19};
        largestRange(array);



    }
}
