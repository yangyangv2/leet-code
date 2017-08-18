package prob209.minimum.size.subarray.sum;

/**
 * Created by yanya04 on 8/18/2017.
 */
public class Solution {
    /*
    consecutive:

*/
    public int minSubArrayLen(int s, int[] nums) {

        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) {
            if(nums[0] < s){
                return nums[0];
            } else {
                return 0;
            }
        }

        int a = 0, b = 0;

        int cur_sum = 0;
        int min_len = Integer.MAX_VALUE;
        while(b < nums.length){
            cur_sum += nums[b];
            while(cur_sum >= s){
                min_len = Math.min(min_len, b - a + 1);
                cur_sum -= nums[a];
                a ++;
            }
            b ++;
        }
        return min_len == Integer.MAX_VALUE ? 0 : min_len;
    }
}
