import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: xhwang
 * @Date: 12/17/22 11:15 PM
 */
public class HW2 {

    /**
     * 4 11
     * 802
     * 743
     * 457
     * 539
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int ropeNum, target = 0;
//        ropeNum = in.nextInt();
//        target = in.nextInt();
//        Integer[] list = new Integer[ropeNum];
//        int j = 0;
//        while (j < ropeNum) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int len = in.nextInt();
//            list[j] = len;
//            j++;
//        }

        int ropeNum = 4, target = 11;

        Integer[] list = new Integer[ropeNum];
        list[0] = 802;
        list[1] = 743;
        list[2] = 457;
        list[3] = 539;

        if (target == 0) {
            return;
        }
        Arrays.sort(list);
        int count = 0;
        int max = 1;
        for (int i = 1; i < list[0]; i++) {
            for (int index = 0; index < list.length; index++) {
                count += list[index] / i;
            }
            if (count >= target) {
                count = 0;
                continue;
            }
            max = i-1;
            break;
        }
        System.out.println(max);
    }


}
