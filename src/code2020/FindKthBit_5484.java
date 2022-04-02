package code2020;

/**
 * @author: xhwang
 * @Date: 2020-08-09 11:38
 */
public class FindKthBit_5484 {

    private static char findKthBit(int n, int k) {
        String s = cal(n);
        return s.toCharArray()[k - 1];
    }

    private static String cal(int n) {
        if (n == 1) {
            return "0";
        } else if (n == 2) {
            return "011";
        } else if (n == 3) {
            return "0111001";
        } else if (n == 4) {
            return "011100110110001";
        } else {
            String origin = cal(n - 1);
            StringBuilder s = new StringBuilder(origin);
            s.append("1");
            for (int i = origin.length() - 1; i >= 0; i--) {
                s.append(origin.toCharArray()[i] == '0' ? 1 : 0);
            }
            return s.toString();
        }

    }

    public static void main(String[] args) {
        System.out.println(findKthBit(3, 1));
    }
}
