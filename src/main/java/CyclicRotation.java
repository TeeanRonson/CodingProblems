public class CyclicRotation {

    public static void KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        int j = 0;
        int pattern[] = computeLPSArray(pat);


        int i = 0;
        while (i < N) {

            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }

            if (j == M) {
                System.out.println("Found pattern " + "at index " + (i - j));
                j = pattern[j - 1];

            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {

                if (j != 0) {
                    j = pattern[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
    }

    public static int[] computeLPSArray(String pat) {
        int j = 1;
        int i = 0;
        int[] pattern = new int[pat.length()];

        pattern[0] = 0;

        while (j < pat.length()) {
            if (pat.charAt(j) == pat.charAt(i)) {
                i++;
                pattern[j] = i;
                j++;
            } else {
                if (i != 0) {
                    i = pattern[i - 1];
                } else {
                    pattern[j] = i;
                    j++;
                }
            }
        }
        return pattern;
    }

        public static void main(String[] args) {

            String txt = "ABABCABCABABABD";
            String pat = "ABABD";
            KMPSearch(pat, txt);
        }

}
