/**
 * @author: xhwang
 * @Date: 3/31/22 11:48 PM
 */
public class FindMedianSortedArrays4 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int medianIndex = (nums1.length + nums2.length) / 2;


        //奇数个，取第 medianIndex 大的数字
        if (!((nums1.length + nums2.length) % 2 == 0)) {
            return getMedianIndexValue(nums1, nums2, medianIndex);
        }


        //偶数：取第 medianIndex 大的数字和 medianIndex-1 取平均值
        return (getMedianIndexValue(nums1, nums2, medianIndex) + getMedianIndexValue(nums1, nums2, medianIndex - 1)) / 2.0;


    }


    private static double getMedianIndexValue(int[] nums1, int[] nums2, int medianIndex) {
        double median = 0.0;
        int nowIndexSum = 0;
        if (nums1.length == 0) {
            return nums2[medianIndex];
        }
        if (nums2.length == 0) {
            return nums1[medianIndex];
        }


        int i = 0;
        int j = 0;


        while (i < nums1.length || j < nums2.length) {
            if (i >= nums1.length) {
                median = nums2[j];
                j++;
            } else if (j >= nums2.length) {
                median = nums1[i];
                i++;
            } else if (nums1[i] >= nums2[j]) {
                median = nums2[j];
                j++;
            } else if (nums1[i] < nums2[j]) {
                median = nums1[i];
                i++;
            }


            nowIndexSum++;
            if (nowIndexSum == medianIndex + 1) {
                return median;
            }
        }




        return median;
    }

}
