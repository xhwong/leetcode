package code2019;

/**
 * @author xhwong
 * @date 2019/8/28
 */
public class day0918 {
    public static void main(String[] args) {
//        System.out.println(dayOfTheWeek(31, 8, 2019));
        System.out.println(dayOfTheWeek(29, 2, 2016));

    }


    public static String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        Integer[] dayCol = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //题目范围是从1971年开始，1971年的第一天是星期五
        int days = 5;

        //计算总天数
        for (int i = 1971; i < year; i++) {
            days = isLeap(i) ? days + 366 : days + 365;
        }

        for (int i = 0; i < month - 1; i++) {
            days += dayCol[i];
        }

        if (isLeap(year) && month > 2) {
            days = days + 1;
        }
        days = days + day - 1;

        return week[days % 7];
    }

    private static boolean isLeap(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}