


public class DoesArrayGiveValue {

    private static boolean[] used;


    private static boolean find(int[] nums, int target) {

        used = new boolean[nums.length];

        return permute(nums, 0, target);
    }

    private static boolean permute(int[] nums, int index,  int target) {

        if(index == nums.length) {
            if(target == 0) return true;
            else return false;
        }

        for(int i = 0; i < nums.length; i++) {
            boolean res = false;
            if(!used[i]) {
                used[i] = true;
                res |= permute(nums, index + 1, target - nums[i]);
                res |= permute(nums, index + 1, target + nums[i]);
                res |= permute(nums, index + 1, target * nums[i]);
                res |= permute(nums, index + 1, target / nums[i]);
                used[i] = false;
            }
            if(res) return true;
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 4, 5};

        System.out.println(find(nums, 29));
    }
}
