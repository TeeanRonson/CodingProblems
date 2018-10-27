public class MaxDiskStorage {


    private int[][] v;
    private int rows;
    private int columns;
    private final int COST = 1;
    public MaxDiskStorage(int[] items, int maxCapacity) {
        this.rows = items.length;
        this.columns = maxCapacity;
        this.v = new int[this.rows][this.columns];
    }

    /**
     * Find values to fit in the table
     * @param items
     * @param maxCapacity
     * @return
     */
    public int calculate(int[] items, int maxCapacity) {

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                if (i == 0 || j == 0) {
                    v[i][j] = 0;
                } else if (items[i] <= j){
                    v[i][j] = Math.max(COST + v[i-1][j-(items[i])], v[i-1][j]);
                } else {
                    v[i][j] = v[i-1][j];
                }
            }
            print();
        }

        return v[items.length - 1][maxCapacity];
    }

    /**
     * Print the table
     */
    public void print() {

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                System.out.print(this.v[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {

        int max = 8;
        int[] items = {0, 2, 2, 3, 4};

        MaxDiskStorage md = new MaxDiskStorage(items, max + 1);
        int maxStorage = md.calculate(items, max);

        System.out.println("Result: " + maxStorage);

    }
}
