public class FindValueInCyclicArray {

    public static int search(int[] nums, int target) {

        if (nums.length == 0) return -1;

        return search(nums, target, 0, nums.length - 1);

    }

    public static int search(int[] nums, int target, int start, int end) {

        int mid = (start + end)/2;
        if (nums[mid] == target) {
            return mid;
        }

        if (start == end || start >= nums.length || end < 0) return -1;

        if (nums[mid] > target) {
            if (nums[start] > target) {
                return search(nums, target, mid + 1, end);
            } else {
                return search(nums, target, 0, mid - 1);
            }
        } else {
            System.out.println("Hello: " + mid);
            if (nums[end] >= target) {
                return search(nums, target, mid + 1, end);
            } else {
                System.out.println("Hello: " + mid);
                return search(nums, target, 0, mid - 1);
            }
        }
    }
}