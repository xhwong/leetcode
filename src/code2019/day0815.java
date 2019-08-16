package code2019;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xhwong
 * @date 2019/8/15
 */
public class day0815 {

    public static void main(String[] args) {

//        [[1,3],[2,6],[8,10],[15,18]]
//        int[][] arr1 = {{2, 3}, {4, 5}, {6, 7}, {1, 10}};
//        int[][] arr1 = {{1, 2}, {4, 6}, {3, 5}};
//        int[][] arr1 = {{1, 4}, {0, 2}, {3, 5}};
        int[][] arr1 = {{0, 2}, {2, 3}, {4, 4}, {0, 1}, {5, 7}, {4, 5}, {0, 0}};
        int[][] result = merge(arr1);

        print(result);
    }


    public static int[][] merge(int[][] intervals) {
        int start = 0;
        int end = 1;
        int bound = 2;


        if (intervals.length < bound) {
            return intervals;
        }

        //二维数组排序
        for (int i = 0; i < intervals.length; i++) {
            int[] currentI = intervals[i];
            for (int j = i + 1; j < intervals.length; j++) {
                int[] currentJ = intervals[j];
                if (currentI[start] > currentJ[start]) {
                    swap(currentI, currentJ);
                }
            }
        }
        List<int[]> list = new ArrayList();
        list.add(intervals[0]);
        //相邻合并
        for (int i = 0; i < intervals.length; i++) {
            int[] temp = new int[intervals[i].length];
            int[] currentI = intervals[i];
            int[] before = list.get(list.size() - 1);

            if (before[end] >= currentI[start] && before[end] <= currentI[end]) {
                temp[start] = before[start];
                temp[end] = currentI[end];
                list.remove(before);
                list.add(temp);
            } else if (before[end] >= currentI[start] && before[end] > currentI[end]) {
              //need do nothing
            } else {
                list.add(currentI);
            }
        }

        int[][] result = new int[list.size()][];
        int index = 0;
        for (int[] temp : list) {
            result[index++] = temp;
        }
        return result;

    }

    public static void swap(int[] currentI, int[] currentJ) {
        int[] swap = new int[currentI.length];
        System.arraycopy(currentI, 0, swap, 0, currentI.length);
        System.arraycopy(currentJ, 0, currentI, 0, currentI.length);
        System.arraycopy(swap, 0, currentJ, 0, currentJ.length);
    }


    public static void print(int[][] result) {
        if (result == null) {
            return;
        }
        for (int i = 0; i < result.length; i++) {
            int[] current = result[i];
            System.out.print("第" + i + "个数组  ");
            for (int j = 0; j < current.length; j++) {
                System.out.print(current[j] + " ");
            }
            System.out.println();
        }
    }
}
