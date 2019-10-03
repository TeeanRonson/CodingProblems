public class LongestPalindromicSubstring {

        public static String longestPalindromicSubstring(String str) {

            if (str == null) return "";
            if (str.length() == 1) return str;
            String currLongest = "";
            int currLength = 0;

            // System.out.println(str.substring(0, 1));
            for (int i = 0; i < str.length(); i++) {
                for (int j = i+1; j <= str.length(); j++) {
                    String currSub = str.substring(i, j);
                    System.out.println(currSub);
                    boolean isPalin = checkPalindrome(currSub);
                    System.out.println(isPalin);
                    if (isPalin && currSub.length() > currLength) {
                        currLongest = currSub;
                        currLength = currSub.length();
                    }
                }
            }
            System.out.println("End:" + currLongest);
            return currLongest;
        }

        private static boolean checkPalindrome(String substring) {

            int i = 0;
            int j = substring.length() - 1;
            while (i <= j) {
                if (substring.charAt(i) != substring.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }

        public static void main(String[] args) {

//            System.out.println(longestPalindromicSubstring("a"));
            System.out.println(longestPalindromicSubstring("it's highnoon"));
            String test = "it's highnoon";
            System.out.println(test.substring(0, test.length()));

            String word = "w";

            String other = word.charAt(0) + "hello";
            System.out.println(other);

        }

}
