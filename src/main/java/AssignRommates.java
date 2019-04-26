import java.util.ArrayList;
import java.util.HashMap;

public class AssignRommates {


    /**
     * Method only finds optimal room mates
     * @param array
     * @return
     */
    public static ArrayList<Integer[]> findOptimal(int[] array) {

        HashMap<Integer, Integer> options = new HashMap<>();
        ArrayList<Integer[]> result = new ArrayList<>();
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

    public static ArrayList<Integer[]> findOptimal1(int[] array) {

        ArrayList<Integer[]> assigned = new ArrayList<>();
        ArrayList<Integer> unassigned = new ArrayList<>();
        boolean[] added = new boolean[array.length];


        
//        for (int i = 0; i < array.length; i++) {
//            if (i == array[array[i]] && array[array[i]] == i) {
//                result.add(new Integer[] {i, array[i]});
//                added[i] = true;
//                added[array[i]] = true;
//            }
//        }
//
//
//
//        System.out.println(unassigned);
//
//        for (int i = 0; i < unassigned.size(); i += 2) {
//            result.add(new Integer[] {unassigned.get(i), unassigned.get(i + 1)});
//        }

        return assigned;
    }

    public static void print(ArrayList<Integer[]> assigned) {

        for (Integer[] i: assigned) {
            for (int x: i) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {


        int[] a = {1, 0, 1, 1};//two people get assigned
        int[] b = {2, 3, 0, 1};//everyone is optimal
        int[] c = {1, 3, 1, 0};//no one gets their optimal
        int[] d = {0, 0, 3, 2};//2, 3 gets their optimal


        for (Integer[] i: findOptimal1(d)) {
            for (int x: i) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
