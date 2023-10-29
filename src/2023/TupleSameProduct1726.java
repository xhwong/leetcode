import java.util.HashMap;
import java.util.Map;

public class TupleSameProduct1726 {
    public static void main(String[] args) {
        int[] nums = {2,3,4,6};
        System.out.println(tupleSameProduct(nums));
    }


    public static int tupleSameProduct(int[] nums) {
        int n = nums.length; // 数组长度
        Map<Integer, Integer> hash = new HashMap<>(); // 哈希表
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // 双重循环枚举
                hash.put(nums[i] * nums[j], hash.getOrDefault(nums[i] * nums[j], 0) + 1); // 统计每种乘积的出现次数
            }
        }
        int ans = 0; // 答案
        for (Integer v: hash.values()) { // 遍历哈希表的映射值集合
            ans += 4 * v * (v - 1); // 累加该乘积对答案的贡献值
        }
        return ans;

    }
}
