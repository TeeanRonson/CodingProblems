import java.util.Arrays;

public class KMP {

    public static boolean KMP(String string, String substring) {

        int[] pattern = buildPattern(substring);

        System.out.println();
        for (int i: pattern) {
            System.out.print(i + " ");
        }

        return doesMatch(string, substring, pattern);

    }

    public static int[] buildPattern(String substring) {
        int[] pattern = new int[substring.length()];

        Arrays.fill(pattern, -1);

        for (int i: pattern) {
            System.out.print(i + " ");
        }
        int j = 0;
        int i = 1;

        while(i < substring.length()) {
            if (substring.charAt(i) == substring.charAt(j)) {
                pattern[i] = j;
                i++;
                j++;
            } else if (j > 0) {
                j = pattern[j-1] + 1;
            } else {
                i++;
            }
        }
        return pattern;
    }

    public static boolean doesMatch(String string, String substring, int[] pattern) {


        return false;
    }


    public static void main(String[] args) {

        String string = "ABABCABCABABABD";
        String substring = "ABABD";
        KMP(string, substring);

    }



}