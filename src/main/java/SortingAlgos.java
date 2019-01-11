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
     * iterative Merge Sort
     * power of 2
     *
     *
     * @param array
     */
    public static void mergeSort(int[] array) {

        for (int i = 1; i < array.length; i = i*2) {
            print(array);
            for (int j = 0; j < array.length; j += i*2) {
                merge(array, j, j + i*2);
            }
        }
        print(array);
    }

    private static void merge(int[] array, int start, int end) {

        int middle = (start + end)/2;
        int[] merge = new int[end];
        int i = start;
        int j = middle;
        int k = 0;

        while (i < middle && j < end) {
            if (array[i] <= array[j]) {
                merge[k] = array[i];
                k++;
                i++;
            } else {
                merge[k] = array[j];
                k++;
                j++;
            }
        }

        while(i < middle) {
            merge[k] = array[i];
            k++;
            i++;
        }

        while(j < end) {
            merge[k] = array[j];
            k++;
            j++;
        }

        copyBack(merge, array, start, end);
    }

    private static void copyBack(int[] merge, int[] array, int start, int end) {

        int k = 0;
        for (int i = start; i < end; i++) {
            array[i] = merge[k];
            k++;
        }

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

        int[] easy = {4, 3, 1, 2};
        int[] medium = {4, 3, 1, 5, 2, 8, 7, 6, 10, 9, 11, 12, 13, 15, 16, 14};

//        SelectionSort(easy);
//        QuickSort(0, easy.length - 1, easy);
//        QuickSort(0, medium.length - 1, medium);


        mergeSort(medium);
    }
}
