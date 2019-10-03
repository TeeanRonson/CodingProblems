import java.util.ArrayList;
import java.util.Stack;

public class GoogleOA2019 {


    public static String solution(String S, int K) {

        Stack<Character> stack = new Stack<Character>();
        ArrayList<Character> toReturn = new ArrayList<Character>();

        for (char c: S.toCharArray()) {
            if (c != '-') {
                if (c >= 'a' &&  c <= 'z') {
                    c = convertToUpperCase(c);
                }
                stack.push(c);
            }
        }

        int i = 0;
        while (!stack.isEmpty()) {
            toReturn.add(0, stack.pop());
            i++;
            if (i == K && !stack.isEmpty()) {
                toReturn.add(0, '-');
                i = 0;
            }
        }

        String result = "";
        for (char c: toReturn) {
            result += c;
        }

        return result;
    }


    private static char convertToUpperCase(char letter) {

        char toReturn = (char) (letter + ('A' - 'a'));

        return toReturn;
    }


    public static void main(String[] args) {

        String test = "2-4A0r7-4k";
        int k = 4;

        System.out.println(solution(test, 4));


    }

}
