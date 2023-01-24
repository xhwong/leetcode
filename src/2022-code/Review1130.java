/**
 * @author: xhwang
 * @Date: 11/30/22 8:06 PM
 */
public class Review1130 {


    public static void main(String[] args) {
        int n = 10;
        int count = 0;

        for(int i = 0;i<=n;i++){
            int result = splitForNumber(i);
//            System.out.println("i :"+ i + " "+result);
            count += result;
        }
        System.out.println(count);
    }

    /**
     * 判断给定的数字是不是质数
     *
     * @param n
     * @return
     */
    private static int splitForNumber(int n) {
        //1、小数
        //2、偶数
        if (n <= 1 || n > 2 && n % 2 == 0) {
            return 0;
        } else if (n == 2) {
            return 1;
        }

        //3、奇数 :  9
        for (int i = 3; i <= Math.sqrt(n); i = i + 2) {
            if (n % i == 0) {
                return 0;
            }
        }

        return 1;
    }
}
