import javax.xml.soap.Text;
import java.util.ArrayList;
import java.util.List;

public class TextJustification {


    public TextJustification() {

    }

    public static void printNeatly(String words, int size, int limit) {

        int[][] extras = new int[size][size];
        int[][] costs = new int[size][size];
        int[] arrangement = new int[size + 1];
        int[] p = new int[size + 1];

        String[] input = words.split("\\s+");

        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                if (i == j) {
                    extras[i][j] = limit - input[i].length();
                } else if(j > i){
                    extras[i][j] = extras[i][j-1] - input[j].length() -1;
                }
            }
        }
        print(extras);

        for (int i = 1; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (extras[i][j] < 0) {
                    costs[i][j] = Integer.MAX_VALUE;
                } else if (j == size - 1 && extras[i][j] >= 0) {
                    costs[i][j] = 0;
                } else {
                    costs[i][j] = (int) Math.pow(extras[i][j], 3);
                }
            }
        }
        print(costs);

        arrangement[0] = 0;
        for (int j = 1; j < size; j++) {
            arrangement[j] = Integer.MAX_VALUE;
            for (int i = 1; i <= j; i++) {
                if (arrangement[i - 1] + costs[i][j] < arrangement[j]) {
                    arrangement[j] = arrangement[i - 1] + costs[i][j];
                    p[j] = i;
                }
            }
        }

        System.out.println();
        System.out.println("Arrangement");
        for (int a: arrangement) {
            System.out.print(a + " ");
        }

        System.out.println();
        System.out.println("P");
        for (int a: p) {
            System.out.print(a + " ");
        }
    }

    public static void print(int[][] table) {

        for (int i = 1; i < table.length; i++) {
            System.out.println();
            for (int j = 1; j < table.length; j++) {
                System.out.print(table[i][j] + "\t\t");
            }
        }
        System.out.println();
    }



    public static void main(String[] args) {

        String words = "- My name is Rong";
        // My name is
        // Rong
        // and I am always
        // working

        printNeatly(words, 50, 10);
    }
}
