package code2020;

/**
 * @author : xhwang
 * @date : 2020-06-21 13:49
 * @link :https://leetcode.com/problems/two-sum/
 */
public class TwoSum_1 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] result = twoSum(nums, 9);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
        result = twoSum(nums, 18);
        for (int i : result) {
            System.out.print(i + " ");
        }

    }

    private static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int[] result = new int[2];
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
