import java.util.ArrayList;
import java.util.Arrays;

public class ThreeNumberSum {

    public static ArrayList<Integer[]> threeNumberSum(Integer[] array, int targetSum) {

        print(array);
        Arrays.sort(array);
        ArrayList<Integer[]> result = new ArrayList<>();
        print(array);

        for (int k = 0; k < array.length - 2; k++) {
            int i = k + 1, j = array.length - 1;
            while (i < j) {
                int sum = array[k] + array[i] + array[j];
                if (targetSum == sum) {
                    Integer[] triplet = {array[k], array[i], array[j]};
                    result.add(triplet);
                    i++;
                    j--;
                } else if (sum < targetSum) {
                    i++;
                } else if (sum > targetSum) {
                    j--;
                }
            }
        }

        return result;

    }


    public static void print(Integer[] array) {

        for (int i: array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {

        Integer[] one = {12, 3, 1, 2, -6, 5, -8, 6};

        ArrayList<Integer[]> a = threeNumberSum(one, 0);

        System.out.println("Results");
        for (Integer[] x : a) {
            for (int i = 0; i < x.length; i++) {
                System.out.print(x[i] + " ");
            }
            System.out.println();
        }

    }
}