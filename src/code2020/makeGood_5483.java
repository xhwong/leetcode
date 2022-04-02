package code2020;

/**
 * @author: xhwang
 * @Date: 2020-08-09 10:58
 */
public class makeGood_5483 {


    public static String makeGood(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }

        String[] tempArray = s.split("");
        StringBuilder result = new StringBuilder();

        if (s.length() == 2 && tempArray[0].toUpperCase().equals(tempArray[1])) {
            return "";
        } else {
            int in = 0;
            for (int i = 0; i <= s.length() - 1; i++) {
                String now = tempArray[i];
                if (i <= s.length() - 2 && !now.equals(tempArray[i + 1])
                        && (now.toUpperCase().equals(tempArray[i + 1]) || now.toLowerCase().equals(tempArray[i + 1]))) {
                    i = i + 1;
                    in = in + 1;
                } else {
                    result.append(tempArray[i]);
                }
            }

            return in == 0 ? result.toString() : makeGood(result.toString());
        }
    }


    public static void main(String[] args) {
        System.out.println(makeGood("leEeetcode"));
        System.out.println(makeGood("abBAcC"));
        System.out.println(makeGood("leEeetcode"));


    }
}
