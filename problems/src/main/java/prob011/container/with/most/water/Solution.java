package prob011.container.with.most.water;

/**
 * Created by yanya04 on 7/22/2017.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        assert solution.maxArea(new int[]{1,2,3,4,5}) == 6;

    }

    public int maxArea(int[] height) {

        if(height.length <2) return 0;
        int p1 = 0, p2 = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < height.length; i ++){
            maxArea = Math.max(Math.min(height[p1], height[p2]) * (p2 - p1), maxArea);
            if(height[p1] > height[p2]) p2--;
            else p1++;
        }
        return maxArea;
    }
}
