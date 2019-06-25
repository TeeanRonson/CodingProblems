public class SmallestDifference {

    /**
     *
     */

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {

        if (arrayOne.length == 0 || arrayTwo.length == 0 || arrayOne == null || arrayTwo == null) {
            return new int[]{};
        }

        int smallest = Integer.MAX_VALUE;
        int[] result = new int[2];

        for (int i = 0; i < arrayOne.length; i++) {
            for (int j = 0; j < arrayTwo.length; j++) {
                int curr = Math.abs(arrayOne[i] - arrayTwo[j]);
                if (curr <= smallest) {
                    smallest = curr;
                    result[0] = arrayOne[i];
                    result[1] = arrayTwo[j];
                }
            }
        }

        return result;
    }
}
