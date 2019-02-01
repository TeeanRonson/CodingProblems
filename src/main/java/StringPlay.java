public class StringPlay {


    public static String longestSubstring(String a, String b) {

        if (a.length() == 0 || b.length() == 0) return "";
        String result = "";

        int[][] board = new int[a.length()][b.length()];

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                System.out.println("j: " + j);
                if (a.charAt(i) == b.charAt(j)) {
                    if (i == 0 || j == 0) {
                        board[i][j] = 1;
                    } else {
                        board[i][j] = board[i-1][j-1] + 1;
                    }
                    if (board[i][j] > result.length()) {
                        result = a.substring(i - board[i][j] + 1, i + 1);
                        System.out.println("result: " + result);
                    }
                }

            }
        }
        return result;

    }
    public static void main(String[] args) {


        String a = "ABAB";
        String b = "BABA";

        System.out.println(longestSubstring(a, b));


    }
}
