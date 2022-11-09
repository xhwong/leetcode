
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: xhwang
 * @Date: 10/17/22 12:09 AM
 */
public class Main1 {

    /**
     * 6
     * 10 20 30 15 23 12
     * 3
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> array = new ArrayList<>();
        int step = 0;
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            for (int i = 0; i < a; i++) {
                int b = in.nextInt();
                array.add(b);
            }
            step = in.nextInt();
            break;
        }

        //ex1:无值
        //ex2:窗口超过数组长度，理论上正数则为全部求和，因有负数，不确定窗口超出溢出
        if (array.size() <= 0 || step <= 0) {
            System.out.println(0);
        }
        //nor
        int result = 0;
        int max = 0;
        for (int i = 0; i < step; i++) {
            max = max + array.get(i);
        }

        for (int i = 0; i < array.size(); i++) {
            for (int j = i; j < step + i && j < array.size(); ) {
                result = result + array.get(j);
                j++;
            }

            if (i + step >= array.size()) {
                break;
            }

            System.out.println(result);
            if (result >= max) {
                max = result;
            }
            result = 0;
        }

        System.out.println(max);

    }
}
