package prob209.minimum.size.subarray.sum;

/**
 * Created by yanya04 on 8/18/2017.
 */
public class Solution {
    /*
    consecutive:
*/
    public int minSubArrayLen(int s, int[] nums) {

        int left = 0, right = 0, sum = 0, dist = Integer.MAX_VALUE;
        while(right < nums.length){
            sum += nums[right ++];
            while(sum >= s){
                dist = Math.min(dist, right - left);
                sum -= nums[left ++];
            }

        }
        return dist == Integer.MAX_VALUE ? 0: dist;
    }
}
