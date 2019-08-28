package code2019;

/**
 * @author xhwong
 * @date 2019/8/21
 */
public class day0821 {
    public static void main(String[] args){
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(heights));
    }

    public static int trap(int[] height) {
        int total = 0;
        if(height.length <3){
            return total;
        }

        int[] left = new int[height.length];
        int[] right = new int[height.length];

        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }

        right[height.length-1] = height[height.length-1];
        for (int i = height.length-2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], height[i]);
        }

        for (int i = 1; i < height.length-1; i++) {
            int offset = Math.min(left[i], right[i]) - height[i];
            if (offset > 0) {
                total += offset * 1;
            }
        }

        return total;
    }



}
