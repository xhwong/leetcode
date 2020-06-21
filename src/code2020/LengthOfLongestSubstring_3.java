package code2020;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xhwong
 * @date 2020/6/3
 * @link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstring_3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }


    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        Set<String> strSet = new HashSet<>();

        int len = 0;
        String[] sStr = s.split("");
        for (int i = 0; i < sStr.length; i++) {
            String single = sStr[i];
            if (!strSet.add(single)) {
                i = i - strSet.size();
                strSet = new HashSet<>();
            }
            if (len < strSet.size()) {
                len = strSet.size();
            }

        }
        return len;
    }
}
