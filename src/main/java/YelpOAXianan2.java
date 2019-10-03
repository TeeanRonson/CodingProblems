import java.util.ArrayList;
import java.util.HashSet;

public class YelpOAXianan2 {


    public static ArrayList<ArrayList<Integer>> powerset(ArrayList<Integer> array) {

        ArrayList<ArrayList<Integer>> powersets = new ArrayList<>();
        getPowerSets(array, new ArrayList<Integer>(), powersets, 0);
        return powersets;
    }

    private static void getPowerSets(ArrayList<Integer> array, ArrayList<Integer> currSet, ArrayList<ArrayList<Integer>> powersets, int max) {

        if (currSet.size() == max) {
            powersets.add(currSet);
        }
        if (!array.isEmpty()) {
            for (int i = 0; i < array.size(); i++) {
                ArrayList<Integer> newArray = new ArrayList<Integer>(array);
                newArray.remove(i);
                ArrayList<Integer> newCurrSet = new ArrayList<Integer>(currSet);
                newCurrSet.add(array.get(i));
                getPowerSets(newArray, newCurrSet, powersets, max++);
            }
        }
    }

    public static void main(String[] args) {

//        ArrayList<Integer> array = new ArrayList<>();
//        array.add(1);
//        array.add(2);
//        array.add(3);
//
//        for (ArrayList<Integer> i: powerset(array)) {
//            for (Integer j: i) {
//                System.out.print(j + " ");
//            }
//            System.out.println();
//        }


        HashSet<Integer[]> test = new HashSet<>();

        test.add(new Integer[] {1, 2, 3, 4});
        test.add(new Integer[] {1, 2, 3, 4});
        test.add(new Integer[] {4, 3, 2, 1});



    }
}
