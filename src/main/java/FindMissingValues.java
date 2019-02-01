public class FindMissingValues {

    public static int oneMissing(int[] array) {

        int totalXOR = 0;
        int arrXOR = 0;

        for (int i = 1; i <= array.length + 1; i++) {
            totalXOR ^= i;
        }
        for (int i: array) {
            arrXOR ^= i;
        }

        return totalXOR ^ arrXOR;
    }


    public static void main(String[] args) {

        int[] array = {1, 2, 4, 5};
        System.out.println(oneMissing(array));

    }
}
