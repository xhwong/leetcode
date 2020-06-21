package code2020;

/**
 * @author: xhwang
 * @Date: 2020-06-21 15:48
 * @link: https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianofTwoSortedArrays_4 {
    public static void main(String[] args) {
        /**
         * nums1 = [1, 3]
         * nums2 = [2]
         *
         * The median is 2.0
         *
         * nums1 = [1, 2]
         * nums2 = [3, 4]
         *
         * The median is (2 + 3)/2 = 2.5
         */
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }

    /**
     * log(n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    //todo
    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int sum = len1 + len2;
        //是不是偶数大小，偶数取中间两位，奇数取中间一位
        boolean flag = (len1 + len2) % 2 == 0;
        int mid = sum / 2;
        if (nums1[len1 - 1] >= nums2[0]) {
            return mid >= len1 ? nums2[mid - len1] : nums1[mid];
        } else if (nums2[len2 - 1] >= nums1[0]) {
            return mid >= len2 ? nums1[mid - len1] : nums2[mid];
        } else {

        }
        return 0;
    }

    /**
     * O(n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays_1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int sum = len1 + len2;
        int[] nums = new int[sum];

        for (int i = 0, j = 0, k = 0; k < sum; k++) {
            if (i >= len1) {
                nums[k] = nums2[j];
                j++;
            } else if (j >= len2) {
                nums[k] = nums1[i];
                i++;
            } else
                //如果第一个数组元素大于第二个数组
                if (nums1[i] >= nums2[j]) {
                    nums[k] = nums2[j];
                    j++;
                } else {
                    nums[k] = nums1[i];
                    i++;
                }
        }
        //是不是偶数大小，偶数取中间两位，奇数取中间一位
        boolean flag = (len1 + len2) % 2 == 0;
        int mid = sum / 2;
        return flag ? (nums[mid] + nums[mid - 1]) / 2.0 : nums[mid];
    }
}
