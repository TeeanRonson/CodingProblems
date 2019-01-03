public class RotateArray {

    public static String rotate(String word, int shift) {

        if (shift == 0 || shift > word.length()) {
            return word;
        }

        String back = "";
        String front = "";
        for (int i = 0; i < word.length() - shift; i++) {
            back += word.charAt(i);
        }

        for (int i = word.length() - shift; i < word.length(); i++) {
            front += word.charAt(i);
        }
        return front + back;
    }


    public static void main(String[] args) {


        String test1 = "Hello";
        String test2 = "WeAreTheChampions";

        System.out.println(rotate(test2, 9));


    }
}
