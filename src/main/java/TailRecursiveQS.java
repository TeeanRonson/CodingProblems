public class TailRecursiveQS {


    public TailRecursiveQS() {


    }

    public static void QS(int[] A, int p, int r) {

        int q;

        while(p < r) {
            q = partition(A, p, r);
            QS(A, p, q - 1);
            p = q + 1;
        }

    }


    private static int partition(int[] A, int p, int r) {

        int i = p;
        int j = r - 2;
        int pivot = A[r - 1];

        while (i <= j) {
            if (A[i] > pivot && A[j] <= pivot) {
                swap(A, i, j);
                i++;
                j--;
            } else if (A[i] < pivot) {
                i++;
            } else if (A[j] >= pivot) {
                j--;
            }
        }

        swap(A, i, r - 1);
        print(A);

        return i;
    }

    private static void print(int[] A) {
        for (Integer i: A) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void swap(int[] A, int first, int second) {

        int temp = A[first];
        A[first] = A[second];
        A[second] = temp;

    }


    public static void main(String[] args) {

        int[] A = {2, 7, 3, 5, 9, 6, 3, 2, 1, 8};

        TailRecursiveQS.QS(A, 0, A.length);



    }



}
