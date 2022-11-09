import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: xhwang
 * @Date: 10/17/22 2:12 AM
 */
public class Main3 {
    // 本题为考试多行输入输出规范示例，无需提交，不计分。


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> arr = new ArrayList<>();
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            arr.add(in.nextLine());

            System.out.println(yesOrNo(arr, a));
        }
    }

    private static String yesOrNo(List<String> arry, int a) {
        return "yes";
    }
}

