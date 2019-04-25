public class BinarySearch {

    public static int iterativeBinarySearch(int[] array, int target) {

        return binarySearch(array, 0, array.length -1, target);

    }

    public static int binarySearch(int[] array, int start, int end, int target) {


        while (start <= end) {

            int mid = (start + end)/2;
            if (target == array[mid]) return mid;

            if (target > array[mid]) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }

        return -1;
    }

    public static void main (String[] args) {

        int[] even = {1, 2, 4, 6, 7, 8, 9, 34};
        int[] odd = {1, 2, 4, 6, 7, 8, 9};

        System.out.println(iterativeBinarySearch(even, 34));
        System.out.println(iterativeBinarySearch(odd, 9));




    }
}
