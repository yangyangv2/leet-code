package prob674.longest.continuous.increasing.subsequence;

/**
 * Created by yanya04 on 5/7/2018.
 * Modified by yanya04 on 5/24/2018.
 */
public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0) return 0;

        int max = 0;
        int left = 0, right = 1;
        while(right < nums.length){
            if(nums[right - 1] >= nums[right]){
                max = Math.max(max, right - left);
                left = right;
            }
            right ++;
        }
        max = Math.max(max, right - left);
        return max;
    }
}