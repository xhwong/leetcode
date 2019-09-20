package code2019;

/**
 * Array
 * leetcode 1184
 *
 * @author xhwong
 * @date 2019/9/19
 */
public class day0919 {
    public static void main(String[] args) {
        int[] distance = {7,10,1,12,11,14,5,0};
        int start = 7;
        int destination = 2;
        System.out.println(distanceBetweenBusStops(distance, start, destination));
    }

    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int forward = 0;
        int backward = 0;
        if(start > destination){
            int temp = start;
            start = destination;
            destination = temp;

        }
        for (int i = start; i < destination; i++) {
            forward = forward + distance[i];
        }

        for (int i = 0; i < start; i++) {
            backward = backward + distance[i];
        }

        for (int i = destination; i < distance.length; i++) {
            backward = backward + distance[i];
        }

        return Math.min(forward, backward);

    }

}
