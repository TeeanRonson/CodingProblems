public class SortingAlgos {

    /**
     * Selection Sort
     * Insertion Sort
     * QuickSort
     * MergeSort
     * HeapSort
     */

    /**
     * Sort in ascending order
     * @param values
     */
    public static void SelectionSort(int[] values) {

        for (int i = 0; i < values.length; i++) {
            int smallest = Integer.MAX_VALUE;
            for (int j = i; j < values.length; j++) {
                if (values[j] <= smallest) {
                    smallest = values[j];
                    swap(i, j, values);
                }
            }
        }
        print(values);
    }

    /**
     * Quicksort sort in Ascending
     * @param values
     */
    public static void QuickSort(int low, int high, int[] values) {

        if (low <= high) {
            int pivot = partition(low, high, values);
            QuickSort(low, pivot - 1, values);
            QuickSort(pivot + 1, high, values);
        }

    }

    /**
     * Find pivot for partition
     * @param low
     * @param high
     * @param values
     * @return
     */
    public static int partition(int low, int high, int[] values) {

        int i = low;
        int j = high - 1;
        int pivot = values[high];
        print(values);

        while (i <= j) {
            if (values[i] > pivot && values[j] <= pivot) {
                swap(i, j, values);
                i++;
                j--;
            } else if (values[i] <= pivot) {
                i++;
            } else if (values[j] > pivot) {
                j--;
            }
        }
        swap(i, high, values);
        return i;
    }

    /**
     * Swap positions
     * @param first
     * @param second
     * @param values
     */
    private static void swap(int first, int second, int[] values) {

        int temp = values[first];
        values[first] = values[second];
        values[second] = temp;

    }

    /**
     * Print out array
     * @param array
     */
    public static void print(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

    }


    public static void main(String args[]) {

        int[] easy = {4, 3, 1, 5, 2};
        int[] medium = {4, 3, 1, 5, 2, 18, 7, 45, 34, 13, -1, 0, 78, -5};

//        SelectionSort(easy);
        QuickSort(0, easy.length - 1, easy);
        QuickSort(0, medium.length - 1, medium);
    }
}
