import java.util.ArrayList;

public class FindPowerSet {
    public static ArrayList<ArrayList<Integer>> powerset(ArrayList<Integer> array) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>() {});

        for (Integer e: array) {
            int length = result.size();
            for (int i = 0; i < length; i++) {
                ArrayList<Integer> temp = new ArrayList<Integer>(result.get(i));
                temp.add(e);
                result.add(temp);
            }
        }


        return result;
    }

    public static void main(String[] args) {

        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);

        for (ArrayList<Integer> ele: powerset(array)) {
            System.out.println(ele);
        }
    }
}
