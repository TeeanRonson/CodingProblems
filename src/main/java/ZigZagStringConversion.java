import java.util.ArrayList;
import java.util.List;

public class ZigZagStringConversion {

        public static String convert(String s, int numRows) {

//         if (numRows == 1) return s;
//         String[] vector = new String[numRows];
//         Arrays.fill(vector, "");
//         boolean goingUp = true;
//         int i = 0;
//         for (char c: s.toCharArray()) {
//             if (i < numRows - 1 && goingUp) {
//                 vector[i] += c;
//                 i++;
//             } else if (i > 0 && !goingUp) {
//                 vector[i] += c;
//                 i--;
//             } else if (i == 0) {
//                 vector[i] += c;
//                 goingUp = true;
//                 i++;
//             } else if (i == numRows - 1) {
//                 vector[i] += c;
//                 goingUp = false;
//                 i--;
//             }
//         }

//         String result = "";
//         for (String word: vector) {
//             result += word;
//         }

//         return result;


            if (numRows == 1) return s;

            List<StringBuilder> rows = new ArrayList<>();

            for (int i = 0; i < Math.min(numRows, s.length()); i++) {
                rows.add(new StringBuilder());
            }

            int currRow = 0;
            boolean goingDown = false;

            for (char c: s.toCharArray()) {
                rows.get(currRow).append(c);
                if (currRow == 0 || currRow == numRows -1) goingDown = !goingDown;
                currRow += goingDown ? 1 : -1;
            }

            StringBuilder result = new StringBuilder();
            for (StringBuilder row: rows) {
                result.append(row.toString());
            }


            return result.toString();
        }


        public static void main(String[] args) {

//            String s = "PAYPALISHIRING";
//            String ans = "PAHNAPLSIIGYIR";
//            System.out.println(convert(s, 3));
//            System.out.println(ans);


            char w = 'w';
            char a = 'a';


        }
    }
