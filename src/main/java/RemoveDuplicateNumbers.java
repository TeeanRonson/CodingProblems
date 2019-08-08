import java.util.Arrays;

public class RemoveDuplicateNumbers {


    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;

        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int k = 0; k < nums.length; k++) {
                System.out.print(nums[k]);
            }
            System.out.println("next");
            if (nums[current] != nums[i]) {
                nums[++current] = nums[i];
            }
        }

        for (int k = 0; k < nums.length; k++) {
            System.out.print(nums[k]);
        }
        System.out.println("next");
        return ++current;

//        return nums.length;
    }


    public static void main(String[] args) {


        int[] nums = {0,0,1,1,1,2,2,3,3,4};
//        int[] nums1 = {1, 1, 1};


        System.out.println(removeDuplicates(nums));



    }
}
