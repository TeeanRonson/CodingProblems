import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class RiverSizes {
    public static ArrayList<Integer> riverSizes(int[][] matrix) {

        boolean[][] seen = new boolean[matrix.length][matrix[0].length];
        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (seen[i][j] != true && matrix[i][j] != 0) {
                    int l = findRiverLength(i, j, matrix, seen);
                    results.add(l);
                }
            }
        }
        return results;

    }

    public static int findRiverLength(int i, int j, int[][] matrix, boolean[][] seen) {

        int length = 0;
        ArrayList<Integer[]> toExplore = new ArrayList<>();
        toExplore.add(new Integer[] {i, j});
        while (!toExplore.isEmpty()) {
            Integer[] current = toExplore.remove(0);
            int m = current[0];
            int n = current[1];
            if (seen[m][n]) {
                continue;
            }
            seen[m][n] = true;
            if (matrix[m][n] == 0) {
                continue;
            }
            length++;
            ArrayList<Integer[]> neighbours = getNeighbours(m, n, matrix, seen);
            for (Integer[] a: neighbours) {
                toExplore.add(a);
            }
        }
        return length;
    }
    public static ArrayList<Integer[]> getNeighbours(int i, int j, int[][] matrix, boolean[][] seen) {

        ArrayList<Integer[]> neighbours = new ArrayList<>();

        //Up
        if (i != 0) {
            neighbours.add(new Integer[] {i - 1, j});
        }

        //Down
        if (i != matrix.length - 1) {
            neighbours.add(new Integer[] {i + 1, j});
        }

        //Left
        if (j != 0) {
            neighbours.add(new Integer[] {i, j - 1});
        }

        //Right
        if (j != matrix[0].length - 1) {
            neighbours.add(new Integer[] {i, j + 1});
        }

        return neighbours;
    }



    public static void main(String[] args) {


        int[][] matrix = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}
        };

        ArrayList<Integer> answer = riverSizes(matrix);

        for (int i: answer) {
            System.out.print(i + " ");
        }

    }
}
