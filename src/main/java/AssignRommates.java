import java.util.ArrayList;
import java.util.HashMap;

public class AssignRommates {


    /**
     * Method only finds optimal room mates
     * @param array
     * @return
     */
    public static ArrayList<Integer[]> findOptimal(int[] array) {

        HashMap<Integer, Integer> options = new HashMap<Integer, Integer>();
        ArrayList<Integer[]> result = new ArrayList<Integer[]>();
        boolean[] added = new boolean[array.length];

        for (int i = 0; i < array.length; i++) {
            options.put(i, array[i]);
        }

        for (int i: options.keySet()) {
            if (i == options.get(options.get(i))) {
                result.add(new Integer[] {i, options.get(i)});
                added[i] = true;
            }
        }


        for (int i = 0; i < added.length; i++) {
            if (added[i] == true || added[options.get(i)] == true) {
                continue;
            } else {
                result.add(new Integer[] {i, options.get(i)});
            }
        }

        return result;
    }

    public static void main(String[] args) {


        int[] a = {1, 0, 1, 1};
        for (Integer[] i: findOptimal(a)) {
            for (int x: i) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

}
