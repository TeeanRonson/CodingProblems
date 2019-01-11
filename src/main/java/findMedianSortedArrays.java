public class findMedianSortedArrays {

    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        //ensure array A is <= size of B
        if (m > n) {
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }

        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i + 1; // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}

    //find out length of both arrays - add together
    //if length is odd traverse to the middle
    //if length is even add and divide middle two values
//         int size = nums1.length + nums2.length;
//         int[] nums3 = new int[size];
//         int i = 0, j = 0, k = 0, m = 0;
//         double result = 0;

//         while (i < nums1.length && j < nums2.length) {
//             if (nums1[i] <= nums2[j]) {
//                 nums3[k] = nums1[i];
//                 k++;
//                 i++;
//             } else {
//                 nums3[k] = nums2[j];
//                 k++;
//                 j++;
//             }
//         }

//         while (i < nums1.length) {
//             nums3[k] = nums1[i];
//             k++;
//             i++;
//         }

//         while (j < nums2.length) {
//             nums3[k] = nums2[j];
//             k++;
//             j++;
//         }

//         //even
//         if (size % 2 == 0) {
//             //add size/2 - 1 + size/2
//             result = (double)(nums3[size/2 - 1] + nums3[size/2])/2;

//         } else {
//             //ceiling of size/2
//             result = Math.ceil(nums3[size/2]);
//         }

//         return result;
//}
