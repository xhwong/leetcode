import java.util.HashMap;
import java.util.Map;

import static jdk.nashorn.internal.objects.Global.print;

/**
 * @author: xhwang
 * @Date: 3/31/22 11:06 PM
 */
public class TwoSum1 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;

        BaseUtil.printArray(twoSum(nums, target));
        BaseUtil.printArray(twoSum2(nums, target));
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {
        if (nums.length < 2) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {
            //firstTarget = nums[i];
            int secondTarget = target - nums[i];
            for (int j = i + 1, k = nums.length - 1; k >= j; j++, k--) {
                if (nums[j] == secondTarget) {
                    return new int[]{i, j};
                }
                if (nums[k] == secondTarget) {
                    return new int[]{i, k};
                }
            }
        }
        return null;
    }

    public static int[] twoSum3(int[] nums, int target) {
        if (nums.length < 2) {
            return null;
        }

        Map<Integer, Integer> currentMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            int value = i;
            if (currentMap.containsKey(key)) {
                return new int[]{currentMap.get(key), i};
            } else {
                currentMap.put(nums[i], value);
            }
        }
        return null;
    }
}
