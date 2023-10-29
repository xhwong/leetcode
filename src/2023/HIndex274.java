import java.util.Arrays;

public class HIndex274 {

    public static void main(String[] args) {
        int[] con = {1,3,1};
        System.out.println(hIndex(con));
    }

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);

        int h = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] > h) {
                h++;
            }
        }

        return h;

    }
}
