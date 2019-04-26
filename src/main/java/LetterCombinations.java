import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {

    public static List<String> letterCombinations(String digits) {

        HashMap<Character, Character[]> db = new HashMap<>();
        db.put('2', new Character[] {'a', 'b', 'c'});
        db.put('3', new Character[] {'d', 'e', 'f'});
        db.put('4', new Character[] {'g', 'h', 'i'});
        db.put('5', new Character[] {'j', 'k', 'l'});
        db.put('6', new Character[] {'m', 'n', 'o'});
        db.put('7', new Character[] {'p', 'q', 'r', 's'});
        db.put('8', new Character[] {'t', 'u', 'v'});
        db.put('9', new Character[] {'w', 'x', 'y', 'z'});

        ArrayList<String> result = new ArrayList<>();
        generate(digits, 0, db, new StringBuilder(digits), result);
        return result;

    }

    private static void generate(String digits, int index, HashMap<Character, Character[]> map, StringBuilder builder, ArrayList<String> result) {


        if (index == digits.length()) {
            result.add(builder.toString());
            return;
        }

        char currDig = digits.charAt(index);
        for (char c: map.get(currDig)) {
            builder.setCharAt(index, c);
            generate(digits, index+1, map, builder, result);
        }

    }

    public static void main(String[] args) {

        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("238"));

    }
}
