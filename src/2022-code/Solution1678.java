import java.util.HashMap;
import java.util.Map;

/**
 * @author: xhwang
 * @Date: 11/6/22 10:50 PM
 */
public class Solution1678 {

    public static void main(String[] args) {
        System.out.println(interpret("G()()()()(al)"));
    }

    public static String interpret(String command) {
        String interpret = "";
        Map<String, String> refletMap = new HashMap<>();
        refletMap.put("G", "G");
        refletMap.put("()", "o");
        refletMap.put("(al)", "al");

        String[] commandStr = command.split("");
        for (int index = 0; index < commandStr.length; ) {
            String str = commandStr[index];
            while (refletMap.get(str) == null) {
                index++;
                str = str + commandStr[index];
            }
            interpret = interpret + refletMap.get(str);
            index++;
        }

        return interpret;
    }
}
