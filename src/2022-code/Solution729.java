/**
 * @author: xhwang
 * @Date: 11/17/22 11:29 PM
 */
public class Solution729 {

    public static void main(String[] args) {

        System.out.println(isOrderContain("abcde", "acd"));
    }

    public static int numMatchingSubseq(String s, String[] words) {
        int sum = 0;
        for (int i = 0; i < words.length; i++) {
            if (isOrderContain(s, words[i])) {
                sum++;
            }
        }
        return sum;
    }

    public static boolean isOrderContain(String a, String b) {
        if (a.contains(b)) {
            return true;
        }
        String[] aStr = a.split("");
        String[] bStr = b.split("");
        int j = 0;
        int aimed = 0;

        for (int i = 0; i < bStr.length; i++) {
            for (int k = j; k < aStr.length && aimed != bStr.length; k++) {
                String bc = bStr[i];
                String ac = aStr[k];
                if (ac.equals(bc)) {
                    i++;
                    j = k + 1;
                    aimed += 1;
                }
            }
        }

        return aimed == bStr.length;
    }


}
