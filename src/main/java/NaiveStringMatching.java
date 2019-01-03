public class NaiveStringMatching {


    public static void naiveMethod(String string, String pattern) {

        int n = string.length();
        int m = pattern.length();

        for (int s = 0; s < n - m; s++) {
            System.out.println(s);

            int i;
            for (i = 0; i < m; i++) {
                if (string.charAt(s + i) != pattern.charAt(i)) {
                    System.out.println("break");
                    break;
                }
            }

            if (i == m) {
                System.out.println("Match Found at " + s);
            }

        }

    }

    public static void main(String[] args) {

        String string = "acaabc";
        String pattern = "aab";
        naiveMethod(string, pattern);


    }
}
