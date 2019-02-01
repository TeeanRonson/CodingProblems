public class MaxSubSetSum {

//    public static int maxSubsetSumNoAdjacent(int[] array) {
//
//        boolean[] seen = new boolean[array.length];
//        int sum = 0;
//
//        if (array.length == 1) {
//            return array[0];
//        }
//
//        for (int i = 0; i < array.length; i++) {
//            System.out.println("\nRound");
//            Integer currMax = 0;
//            Integer index = 0;
//            for (int j = 0; j < array.length; j++) {
//                if (j == 0) {
//                    if (seen[j] == true || seen[j + 1] == true) {
//                        continue;
//                    } else {
//
//                        if (array[j] >= currMax) {
//                            currMax = array[j];
//                            index = j;
//                        }
//                    }
//                } else if (j == array.length - 1) {
//                    if (seen[j] == true || seen[j - 1] == true) {
//                        continue;
//                    } else {
//                        if (array[j] >= currMax) {
//                            currMax = array[j];
//                            index = j;
//                        }
//                    }
//                } else {
//                    if (seen[j] == true || seen[j - 1] == true || seen[j + 1] == true) {
//                        continue;
//                    } else {
//                        if (array[j] >= currMax) {
//                            currMax = array[j];
//                            index = j;
//                        }
//                    }
//                }
//            }
//
//            seen[index] = true;
//            System.out.println("here " + currMax);
//            sum += currMax;
////            System.out.println("Sum: " + sum);
//        }
//
//        return sum;
//    }

    public static int maxSubsetSumNoAdjacent(int[] array) {

        if (array.length == 1) {
            return array[0];
        } else if (array.length == 0 || array == null) {
            return Integer.MIN_VALUE;
        }

        int prev = array[1];
        int curr = array[0];
        for (int i = 2; i < array.length; i++) {
            int temp = Math.max(prev, curr + array[i]);
            System.out.print(temp + " ");
            curr = prev;
            prev = temp;
        }
        return prev;
    }

    public static void main(String[] args) {

//        int[] array = {75, 105, 120, 75, 90, 135};
//        int[] array = {1};
//        int[] array = {10, 5, 20, 25, 15, 5, 5, 15};
        int[] array = {4, 3, 5, 200, 5, 3};

        int sum = maxSubsetSumNoAdjacent(array);
        System.out.println("\n" + sum);

    }
}
