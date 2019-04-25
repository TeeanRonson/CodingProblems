import java.lang.reflect.Array;
import java.util.*;

class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> db = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (db.containsKey(diff)) {
                return new int[] {db.get(diff), i};
            }
            db.put(nums[i], i);
        }

        return new int[] {};
    }

    public static void main(String[] args) {


        List<List<Integer>> result = new ArrayList<>();

        ArrayList<Integer> one = new ArrayList<>();

    }
}