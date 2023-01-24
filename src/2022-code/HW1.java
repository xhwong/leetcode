import java.util.*;

/**
 * @author: xhwang
 * @Date: 12/17/22 10:09 PM
 */
public class HW1 {

//    "E980A5"

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        if (input.length() == 2) {
            judgeSingle(input);
        } else {
            judgeMulti(input);
        }

    }

    private static void judgeSingle(String input) {
        List<String> binStr = getBinStr(input);
        if (binStr == null || binStr.size() == 0) {
            System.out.println("-1");
        }
        String start = binStr.get(0);
        if (!start.startsWith("0", binStr.size() - 1)) {
            System.out.println("-1");
            return;
        } else {
            String effectStr = binStr.get(0).substring(1);
            System.out.println(Integer.parseInt(effectStr, 2));
        }
    }

    private static void judgeMulti(String input) {
        List<String> binStr = getBinStr(input);
        if (binStr == null || binStr.size() == 0) {
            System.out.println("-1");
        }

        String start = binStr.get(0);
        if (!start.startsWith("1", binStr.size() - 1)) {
            System.out.println("-1");
            return;
        }

        String effectStr = start.substring(binStr.size());

        for (int i = 1; i < binStr.size(); i++) {
            if (binStr.get(i).startsWith("10")) {
                effectStr = effectStr + binStr.get(i).substring(2);
            } else {
                System.out.println("-1");
                return;
            }
        }

        System.out.println(Integer.parseInt(effectStr, 2));

    }

    private static List<String> getBinStr(String input) {
        List<String> arrayList = new ArrayList<>();
        String[] hexArray = input.split("");
        String result = "";
        for (int i = 0; i < hexArray.length; i++) {
            String binS = getHex2Bin(hexArray[i]);
            if (binS == null) {
                return null;
            }
            result = result + binS;
            if (i % 2 == 1) {
                arrayList.add(result);
                result = "";
            } else {
                // do nothing
            }
        }
        return arrayList;
    }

    private static String getHex2Bin(String hex) {
        Map<String, String> map = new HashMap<>();
        map.put("0", "0000");
        map.put("1", "0001");
        map.put("2", "0010");
        map.put("3", "0011");
        map.put("4", "0100");
        map.put("5", "0101");
        map.put("6", "0110");
        map.put("7", "0111");
        map.put("8", "1000");
        map.put("9", "1001");
        map.put("A", "1010");
        map.put("B", "1011");
        map.put("C", "1100");
        map.put("D", "1101");
        map.put("E", "1110");
        map.put("F", "1111");
        return map.get(hex);
    }
}
