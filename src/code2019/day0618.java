package code2019;

/**
 * @author xhowng
 * @date 2019/6/18
 */
public class day0618 {


    public static void main(String[] args) {
        //53
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5};
        System.out.print(get(nums));
        //67
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }


    /**
     * 67
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        if (a.length() == 0) {
            return b;
        }
        if (b.length() == 0) {
            return a;
        }

        String[] aArr = a.split("");
        String[] bArr = b.split("");

        int aIndex = aArr.length - 1;
        int bIndex = bArr.length - 1;

        String result = "";
        int flag = 0;
        while (bIndex >= 0 && aIndex >= 0) {
            int temp = Integer.valueOf(aArr[aIndex]) + Integer.valueOf(bArr[bIndex]) + flag;
            flag = temp >= 2 ? 1 : 0;
            temp = temp >= 2 ? temp % 2 : temp;
            result = temp + result;
            bIndex--;
            aIndex--;
        }

        if (aIndex >= 0) {
            result = deal(aIndex, aArr, flag) + result;
        } else if (bIndex >= 0) {
            result = deal(bIndex, bArr, flag) + result;
        } else if (flag == 1) {
            result = "1" + result;
        }

        return result;
    }

    public static String deal(int index, String[] arr, int flag) {
        String result = "";
        for (int i = index; i >= 0; i--) {
            int temp = Integer.valueOf(arr[i]) + flag;
            flag = temp >= 2 ? 1 : 0;
            temp = temp >= 2 ? temp % 2 : temp;
            result = temp + result;
        }
        if (flag == 1) {
            result = "1" + result;
        }
        return result;
    }

    /***
     * 53
     * @param nums
     * @return
     */
    public static int get(int[] nums) {
        int current = 0;
        int res = Integer.MIN_VALUE;

        if (nums.length == 0) {
            return 0;
        }
        for (int num : nums) {
            current = Math.max(current + num, num);
            res = Math.max(res, current);
        }

        return res;
    }
}
