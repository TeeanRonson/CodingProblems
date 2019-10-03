public class ReverseDominoes {

    public int minDominoRotations(int[] A, int[] B) {

        if (A.length <= 1 || B.length <= 1) {
            return 0;
        }

        int upperFlips = findMin(A, B);
        int lowerFlips = findMin(B, A);
        int minNoFlipFirst = 0;

        if (upperFlips == -1 && lowerFlips == -1) {
            return -1;
        } else if (upperFlips != -1 && lowerFlips != -1) {
            minNoFlipFirst = Math.min(upperFlips, lowerFlips);
        } else if (upperFlips != -1) {
            minNoFlipFirst = upperFlips;
        } else {
            minNoFlipFirst = lowerFlips;
        }

        int temp = A[0];
        A[0] = B[0];
        B[0] = temp;
        int minFlipFirst = 1;

        upperFlips = findMin(A, B);
        lowerFlips = findMin(B, A);
        if (upperFlips == -1 && lowerFlips == -1) {
            return -1;
        } else if (upperFlips != -1 && lowerFlips != -1) {
            minFlipFirst += Math.min(upperFlips, lowerFlips);
        } else if (upperFlips != -1) {
            minFlipFirst += upperFlips;
        } else {
            minFlipFirst += lowerFlips;
        }

        return Math.min(minFlipFirst, minNoFlipFirst);
    }

    // indicate "first upper value" is target
    public int findMin(int[] A, int[] B) {
        int curr = A[0];
        int flip = 0;
        for (int i = 1; i < A.length; i++) {
            if (curr == A[i]) {
                continue;
            } else if (curr == B[i]) {
                flip++;
            } else {
                return -1;
            }
        }
        return flip;
    }
}
