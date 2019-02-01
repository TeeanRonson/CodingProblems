public class findKthLargest {


    public int findKthLargest(int[] nums, int k) {

        for (int value: nums) {
            System.out.print(value + " ");
        }
        System.out.println();

        sort(0, nums.length - 1, nums, k);

        int result = nums[k - 1];


        return result;
    }


    public void sort(int lowIndex, int highIndex, int[] nums, int k) {

        int pivot;
        if (lowIndex < highIndex) {
            pivot = findPartition(lowIndex, highIndex, nums);
            if (k <= pivot) {
                sort(0, pivot - 1, nums, k);
            } else {
                sort(pivot + 1, highIndex, nums, k);
            }
        }
    }

    public int findPartition(int lowIndex, int highIndex, int[] nums) {

        int i = lowIndex;
        int j = highIndex - 1;
        int pivot = nums[highIndex];

        while (i <= j) {
            if (nums[i] < pivot && nums[j] >= pivot) {
                swap(i, j, nums);
                i++;
                j--;
            } else if (nums[j] < pivot) {
                j--;
            } else if (nums[i] >= pivot) {
                i++;
            }
        }

        swap(i, highIndex, nums);

        for (int value: nums) {
            System.out.print(value + " ");
        }
        System.out.println();

        return i;
    }

    public void swap(int low, int high, int[] nums) {

        int a = nums[low];
        nums[low] = nums[high];
        nums[high] = a;

    }

    public static void main(String[] args) {


//        int[] values = {1, 9, 29, 6, 4, 56, 34, 5, 7};

        int[] values1 = {3,2,3,1,2,4,5,5,6};
        int k = 3;

        findKthLargest fkl = new findKthLargest();
//        System.out.println(fkl.findKthLargest(values1, k));
        boolean found = false;
        System.out.println(!found);


    }

}
