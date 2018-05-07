package prob011.container.with.most.water;

/**
 * Created by yanya04 on 7/22/2017.
 * Modified by yanya04 on 5/6/2018.
 */
public class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length == 0) return 0;
        int i = 0, j = height.length - 1, area = 0;
        while(i < j){
            area = Math.max(area, (j - i) * Math.min(height[i], height[j]) );
            if(height[i] < height[j]){
                i ++;
            } else {
                j --;
            }

        }
        return area;
    }
}