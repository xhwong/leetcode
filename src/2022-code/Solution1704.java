/**
 * @author: xhwang
 * @Date: 11/11/22 11:33 PM
 */
public class Solution1704 {

    public static void main(String[] args) {
        String s = "book";
        System.out.println(halvesAreAlike(s));
    }

    private static boolean halvesAreAlike(String s) {
        int index = s.length();
        if (index % 2 == 1) {
            return false;
        }

        return calLen(s.substring(0, (index / 2))) == calLen(s.substring((index) / 2));
    }

    private static int calLen(String substring) {
        System.out.println(substring);
        return substring
                .replace("a", "")
                .replace("e", "")
                .replace("i", "")
                .replace("o", "")
                .replace("u", "")
                .replace("A", "")
                .replace("E", "")
                .replace("I", "")
                .replace("O", "")
                .replace("U", "")
                .length();
    }
}
