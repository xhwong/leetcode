import java.util.HashMap;
import java.util.Map;

/**
 * @author: xhwang
 * @Date: 11/8/22 11:31 PM
 */
public class Solution1684 {
    public static void main(String[] args) {
        String allowed = "ab";
        String[] words = {"ad", "bd", "aaab", "baa", "badab"};

        System.out.println(countConsistentStrings(allowed, words));
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        String[] allowedArr = allowed.split("");

        int sum = 0;
        for (int i = 0; i < words.length; i++) {
            String deal = words[i];
            for (int j = 0; j < allowed.length(); j++) {
                deal = deal.replace(allowedArr[j], "");
            }

            if (deal.length() == 0) {
                sum++;
            }
        }
        return sum;
    }
}
