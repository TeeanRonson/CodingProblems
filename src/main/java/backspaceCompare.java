import java.util.LinkedList;

public class backspaceCompare {


    public static boolean backspaceCompare(String S, String T) {

        Character backspace = '/';
        char[] sWord = S.toCharArray();
        char[] tWord = T.toCharArray();
        LinkedList<Character> sList = new LinkedList<>();
        LinkedList<Character> tList = new LinkedList<>();

        for (char c: sWord) {
            if (c == backspace) {
                if (sList.isEmpty()) {
                    continue;
                } else {
                    sList.removeLast();
                    continue;
                }
            }
            sList.add(c);
        }

        for (char c: tWord) {
            if (c == backspace) {
                if (tList.isEmpty()) {
                    continue;
                } else {
                    tList.removeLast();
                    continue;
                }
            }
            tList.add(c);
        }

        System.out.println(sList);
        System.out.println(tList);

        if (sList.equals(tList)) {
            return true;
        }

        return false;
    }


    public static boolean findMatch(String A, String B) {

        //Count the number of backslashes
        int countA = 0;
        int countB = 0;
        char backslash = '/';
        char[] wordA = A.toCharArray();
        char[] wordB = B.toCharArray();
        int i = A.length() - 1;
        int j = B.length() - 1;

        while (i >= 0 || j >= 0) {
            if (j != 0) {
                while (wordB[j] == backslash) {
                    j--;
                    countB++;
                }
            }

            if (i != 0) {
                while (wordA[i] == backslash) {
                    i--;
                    countA++;
                }
            }
            if (countA == 0 && countB == 0) {
                if (wordA[i] == wordB[j]) {
                    i--;
                    j--;
                } else {
                    return false;
                }
            } else {
                if (countA >= 0) {
                    i = i - 1 - (countA);
                }
                if (countB >= 0) {
                    j = j - 1 - (countB);
                }
            }
        }
        return true;
    }

        public static void main(String[] args) {


//      System.out.println(backspaceCompare("ab#c", "ad#c"));

//        System.out.println(backspaceCompare("y#fo##f", "y#f#o##f"));

            System.out.println(findMatch("ab//a", "abc/a"));

        }
}
