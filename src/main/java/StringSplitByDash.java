import java.util.LinkedList;


/**
 * Google OA Practice question
 */
public class StringSplitByDash {

        public static String solution(String S, int K) {

            if (S.length() <= K) {
                return S.toUpperCase();
            }

            String answer = "";
            String newString = S.toUpperCase().replaceAll("[^A-Za-z0-9]", "");
            System.out.println(newString);
            char[] cArray = newString.toCharArray();
            LinkedList<Character> result = new LinkedList<Character>();
            int j = 1;

            for (char c: cArray) {
                result.add(c);
            }


            for (int i = result.size() - 1; i > 0; i--) {
                if (j % K == 0) {
                    result.add(i, '-');
                }
                j++;
            }


            for (char c: result) {
                answer += c;

            }

            System.out.println(answer);


            return answer;


        }


        public static void main(String[] args) {




//            StringSplitByDash.solution("12222-4A0r7-4k", 4);

            System.out.println();
            System.out.println();

            StringSplitByDash.solution("2kasasd12", 2);


        }
}
