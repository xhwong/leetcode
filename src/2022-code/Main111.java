import java.util.*;

/**
 * @author: xhwang
 * @Date: 11/5/22 4:37 PM
 */
public class Main111 {


    public static void main(String[] args) {
        // 异位词
        String[] a = {"abc", "acb","xxx","yyy","XXXX"};

        if (a.length == 0) {
            return;
        }

        List<List<String>> list = getWordGroup(a);
        System.out.println(list);
    }


    private static List<List<String>> getWordGroup(String[] words) {

        Map<String, List<String>> wordGroupMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            char[] tempChar = words[i].toCharArray();
            Arrays.sort(tempChar);

            String key = String.valueOf(tempChar);

            //already has
            if (wordGroupMap.containsKey(key)) {
                wordGroupMap.get(key).add(words[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(words[i]);
                wordGroupMap.put(key, list);
            }
        }
        return new ArrayList<>(wordGroupMap.values());

    }

}
