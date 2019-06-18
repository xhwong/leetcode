package code2019;

/**
 * @author xhwong
 * @date 2019/6/15
 */
public class day0615 {

    public static int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return digits;
        }


        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int result = digits[i] + carry;
            if (result > 9) {
                digits[i] = result % 10;
                carry = 1;
            } else {
                digits[i] += carry;
                carry = 0;
            }
        }


        if (carry == 1) {
            int[] digitsExcp = new int[digits.length + 1];
            digitsExcp[0] = 1;
            System.arraycopy(digits, 0, digitsExcp, 1, digits.length);
            return digitsExcp;
        }

        return digits;
    }
}
