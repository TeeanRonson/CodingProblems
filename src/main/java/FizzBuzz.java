import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {


    public static void fizzBuzz() {

        List<String> result = new ArrayList<>();

        for(int i = 1; i <= 50; i++) {

            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else {
               result.add(String.valueOf(i));
            }

        }
        System.out.println(result);
    }



    public static void main(String[] args) {

        fizzBuzz();

    }

}
