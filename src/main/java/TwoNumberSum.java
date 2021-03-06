import java.util.HashSet;

public class TwoNumberSum {


    /**
     * Uses quick sort to sort
     * Then two pointers that work inwards to find the targetSum
     * @param array
     * @param targetSum
     * @return
     */
    public static int[] twoNumberSum(int[] array, int targetSum) {

        int[] result = new int[2];
        quickSort(array, 0, array.length - 1);

        int i = 0;
        int j = array.length - 1;
        boolean found = false;

        while (i < j) {
            int sum = array[i] + array[j];
            if (sum > targetSum) {
                j--;
            } else if (sum < targetSum){
                i++;
            } else if (sum == targetSum) {
                found = true;
                System.out.println("Sum: " + sum);
                result[0] = array[i];
                result[1] = array[j];
                break;
            }
        }

        print(array);
        print(result);
        System.out.println(targetSum);

        if (found == false) {
            result = new int[0];
        }

        return result;


    }
    public static void quickSort(int[] array, int low, int high) {

        if (low <= high) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }

    }

    public static int partition(int[] array, int low, int high) {

        int i = low;
        int j = high - 1;
        int pivot = array[high];

        while (i <= j) {
            if (array[i] > pivot && array[j] <= pivot) {
                swap(array, i, j);
                i++;
                j--;
            } else if (array[i] <= pivot) {
                i++;
            } else if (array[j] > pivot) {
                j--;
            }
        }

        swap(array, i, high);
        return i;
    }

    public static void swap(int[] array, int i, int j) {

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void print(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }



     public static int[] twoNumberSumII(int[] array, int targetSum) {

            int[] result = new int[] {0 ,0};
            if (array.length == 0) return result;
            HashSet<Integer> db = new HashSet<>();

            for (int i = 0; i < array.length; i++) {
                int diff = targetSum - array[i];
                if (db.contains(array[i])) {
                    return sortArray(result, diff, array[i]);
                } else {
                    db.add(diff);
                    System.out.println(db);
                }
            }

            return new int[] {};
        }

    public static int[] sortArray(int[] array, int one, int two) {

        System.out.println("here");
        System.out.println(array[0]);
        System.out.println(array[1]);
        if (one > two) {
            array[0] = two;
            array[1] = one;
        } else {
            array[0] = one;
            array[1] = two;
        }


        return array;
    }

        public static void main(String[] args) {

            int[] one = new int[] {3, 5, -4, 8, 11, 1, -1, 6};

            int[] two = new int[] {-21, 301, 12, 4, 65, 56, 210, 356, 9, -47};


            twoNumberSumII(two, 164);



        }



}
