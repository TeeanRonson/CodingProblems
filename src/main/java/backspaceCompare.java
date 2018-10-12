import java.util.LinkedList;

public class backspaceCompare {


    public static boolean backspaceCompare(String S, String T) {

        Character backspace = '#';
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


    public static void main(String[] args) {


//        System.out.println(backspaceCompare("ab#c", "ad#c"));

        System.out.println(backspaceCompare("y#fo##f", "y#f#o##f"));



    }
}
