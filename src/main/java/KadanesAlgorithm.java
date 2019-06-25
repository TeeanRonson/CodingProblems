public class KadanesAlgorithm {

    public static int kadanesAlgorithm(int[] array) {

        int currMax = Integer.MIN_VALUE;

        for (int i = 1; i < array.length; i++) {
            array[i] = Math.max(array[i], array[i-1] + array[i]);
            System.out.print(array[i] + " ");
            if (array[i] >= currMax) {
                currMax = array[i];
            }
        }

        if (array[0] > currMax) {
            return array[0];
        }

        System.out.println();
        return currMax;
    }

    public static void main(String[] args) {


        int[] input = new int[] {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};

        System.out.println(kadanesAlgorithm(input));




    }
}
