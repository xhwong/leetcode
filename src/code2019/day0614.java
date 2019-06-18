package code2019;

/**
 * @author bixiuwu
 * @date 2019/6/15
 */
public class day0614 {

    /**
     * int[] nums = {1, 3, 5, 6};
     * System.out.println(searchInsert(nums, 5));
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        int index = 0;

        if (nums.length == 0) {
            return index;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                return i;
            }
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] < target && i + 1 < nums.length && nums[i + 1] >= target) {
                return i + 1;
            }

            index = i + 1;


        }
        return index;
    }

    /**
     * String haystack = "hello";
     * String needle = "ll";
     * haystack = "aaa";
     * needle = "aa";
     * System.out.println(strStr(haystack, needle));
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int index = -1;
        int length = needle.length();

        if (haystack.contains(needle)) {
            String[] hay = haystack.split("");
            String[] need = needle.split("");
            for (int i = 0; i < hay.length; i++) {
                if (hay[i].equals(need[0])) {
                    String temp = haystack.substring(i, i + length);
                    if (temp.equals(needle)) {
                        index = i;
                        break;
                    }
                }
            }
        }
        return index;
    }


    /**
     * int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
     * int[] nums1 = {3, 2, 2, 3};
     * System.out.println(removeElement(nums1, 3));
     * System.out.println(removeElement(nums, 2));
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int result = 0;
        int length = nums.length;
        if (length == 0) {
            return result;
        }


        for (int i = 0; i < length; ) {
            if (nums[i] == val) {

                for (int k = i; k < length - 1; k++) {
                    nums[k] = nums[k + 1];
                }
                length--;
                i = i == 0 ? 0 : i--;
            } else {
                i++;
            }
        }
        return length;

    }
}
