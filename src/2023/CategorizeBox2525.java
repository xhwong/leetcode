public class CategorizeBox2525 {

    public static void main(String[] args) {
//        输入：length = 1000, width = 35, height = 700, mass = 300
//        输出："Heavy"
//        输入：length = 200, width = 50, height = 800, mass = 50
//输出："Neither"
        String a = categorizeBox(2909, 3968, 3272, 727);
        System.out.println(a);
        System.out.println( Math.pow(10, 4));


    }

    public static String categorizeBox(int length, int width, int height, int mass) {
        boolean isHeavy = mass >= 100;
        boolean isBulky = (1L * length * width * height >= Math.pow(10, 9)) || length >= Math.pow(10, 4)
                || width >= Math.pow(10, 4) || height >= Math.pow(10, 4);

        if (isBulky && isHeavy) {
            return "Both";
        }

        if (isBulky) {
            return "Bulky";
        }
        if (isHeavy) {
            return "Heavy";
        }
        return "Neither";

    }
}
