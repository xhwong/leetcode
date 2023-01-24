import java.util.HashMap;
import java.util.Map;

/**
 * @author: xhwang
 * @Date: 11/23/22 10:32 PM
 */
public class Solution1742 {

    public static void main(String[] args) {
        int lowLimit = 1;
        int highLimit = 10;
        System.out.println(countBalls(lowLimit, highLimit));
    }

    public int countBalls1(int lowLimit, int highLimit) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int res = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int box = 0, x = i;
            while (x != 0) {
                box += x % 10;
                x /= 10;
            }
            count.put(box, count.getOrDefault(box, 0) + 1);
            res = Math.max(res, count.get(box));
        }
        return res;
    }


    public static int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> maps = new HashMap<>();
        int count = 1;
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = cal(i);
            if (maps.containsKey(sum)) {
                maps.put(sum,maps.get(sum)+1);
                if(maps.get(sum) > count){
                    count = maps.get(sum);
                }
            }else {
                maps.put(sum,1);
            }
        }
        return count;
    }

    private static int cal(int i) {
        String val = String.valueOf(i);
        if(val.length() ==1){
            return i;
        }
        String[] array = val.split("");
        int sum = 0;
        for (String a : array) {
            sum = sum + Integer.parseInt(a);
        }

        return sum;
    }
}
