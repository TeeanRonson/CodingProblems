import com.sun.tools.javac.util.Pair;

import java.util.*;

public class AmazonOAXianan {

    public static PairInt locationOfTargetValue(int rowCount, int columnCount, List<List<Integer>> matrix, int targetValue) {

        if (rowCount <= 0 || columnCount <= 0 || matrix.isEmpty()) return new PairInt(-1, -1);

        int i = 0;
        int j = columnCount - 1;
        while (i < rowCount && j >= 0) {
            int value = matrix.get(i).get(j);
            if (value == targetValue) {
                return new PairInt(i, j);
            }
            if (value < targetValue) {
                i++;
            } else {
                j--;
            }
        }
        return new PairInt(-1, -1);
    }

    private static class PairInt {
        int first, second;

        PairInt(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {

        List<List<Integer>> matrix = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(3);
        row1.add(1);
        row1.add(31);
        row1.add(40);

        List<Integer> row2 = new ArrayList<>();
        row2.add(10);
        row2.add(33);
        row2.add(40);
        row2.add(660);

        List<Integer> row3 = new ArrayList<>();
        row3.add(22);
        row3.add(43);
        row3.add(161);
        row3.add(702);
        matrix.add(row1);
        matrix.add(row2);
        matrix.add(row3);

        PairInt result = locationOfTargetValue(3, 4, matrix, 22);
        System.out.println(result.first);
        System.out.println(result.second);


    }
}
