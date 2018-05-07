package prob042.trapping.rain.water;

/**
 * Created by yanya04 on 8/20/2017
 * Modified by yanya04 on 3/14/2018
 * Modified by yanya04 on 5/6/2018
 */
public class Solution {
    public int trap(int[] height) {

        if(height == null || height.length == 0) return 0;
        int n = height.length;
        int lmax = 0, rmax = 0, i = 0, j = n - 1, sum = 0;

        while(i <= j){
            lmax = Math.max(lmax, height[i]);
            rmax = Math.max(rmax, height[j]);
            if(lmax <= rmax){
                sum += lmax - height[i];
                i ++;
            } else {
                sum += rmax - height[j];
                j --;
            }
        }

        return sum;
    }
}