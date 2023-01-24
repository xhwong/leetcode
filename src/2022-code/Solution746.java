import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: xhwang
 * @Date: 11/9/22 10:59 PM
 */
public class Solution746 {

    public static void main(String[] args) {
        int n = 5;
        int[][] mines = {{4, 2}};
        System.out.println(orderOfLargestPlusSign(n, mines));
    }

    public static int orderOfLargestPlusSign(int n, int[][] mines) {
        int len = 0;
        //初始化给定的数组
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = 1;
            }
        }

        for (int[] mine : mines) {
            nums[mine[0]][mine[1]] = 0;
        }

        int startX = 4, startY = 2;
        int max = 0;
        for (int i = startX; i < nums.length; ) {
            int j = startY;
            //wei
            if (nums[startX][startY] == 0) {

            }
        }

        return len;
    }


        public int orderOfLargestPlusSign1(int n, int[][] mines) {
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], n);
            }
            Set<Integer> banned = new HashSet<Integer>();
            for (int[] vec : mines) {
                banned.add(vec[0] * n + vec[1]);
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int count = 0;
                /* left */
                for (int j = 0; j < n; j++) {
                    if (banned.contains(i * n + j)) {
                        count = 0;
                    } else {
                        count++;
                    }
                    dp[i][j] = Math.min(dp[i][j], count);
                }
                count = 0;
                /* right */
                for (int j = n - 1; j >= 0; j--) {
                    if (banned.contains(i * n + j)) {
                        count = 0;
                    } else {
                        count++;
                    }
                    dp[i][j] = Math.min(dp[i][j], count);
                }
            }
            for (int i = 0; i < n; i++) {
                int count = 0;
                /* up */
                for (int j = 0; j < n; j++) {
                    if (banned.contains(j * n + i)) {
                        count = 0;
                    } else {
                        count++;
                    }
                    dp[j][i] = Math.min(dp[j][i], count);
                }
                count = 0;
                /* down */
                for (int j = n - 1; j >= 0; j--) {
                    if (banned.contains(j * n + i)) {
                        count = 0;
                    } else {
                        count++;
                    }
                    dp[j][i] = Math.min(dp[j][i], count);
                    ans = Math.max(ans, dp[j][i]);
                }
            }
            return ans;
        }



}
