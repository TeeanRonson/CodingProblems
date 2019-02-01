import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

class Permutations {
    public static ArrayList<ArrayList<Integer>> getPermutations(ArrayList<Integer> array) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();

        if (array.isEmpty() || array == null) {
            return result;
        }
        for (Integer i: array) {
//            System.out.println("new");
            ArrayList<Integer> currentSet = makeCopy(array);
            currentSet.remove(new Integer(i));
            //Add 3 times
            for (int j = 0; j < array.size(); j++) {
                ArrayList<Integer> newSet = new ArrayList<>();
                //Add 3 numbers
                Iterator iterator = currentSet.iterator();
                for (int k = 0; k < array.size(); k++) {
                    if (k == j) {
                        newSet.add(i);
                    } else {
                        Object a = iterator.next();
                        newSet.add((Integer) a);
                    }
                }
                System.out.println(newSet);
                set.add(newSet);
            }
        }

        for (ArrayList<Integer> x: set) {
            result.add(x);
        }

        return result;
    }

    private static ArrayList<Integer> makeCopy(ArrayList<Integer> array) {

        ArrayList<Integer> newList = new ArrayList<Integer>();
        for(Integer i: array) {
            String dummy = String.valueOf(i);
            newList.add(Integer.parseInt(dummy));
        }
        return newList;
    }

    public static void main(String[] args) {

        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(1);
        array.add(2);
        array.add(3);

        ArrayList<ArrayList<Integer>> result = getPermutations(array);

        System.out.println("\n\nResult");
        for (ArrayList<Integer> a: result) {
            for (Integer b: a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}
