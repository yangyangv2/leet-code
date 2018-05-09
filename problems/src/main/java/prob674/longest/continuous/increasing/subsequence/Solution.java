package prob674.longest.continuous.increasing.subsequence;

/**
 * Created by yanya04 on 5/7/2018.
 */
public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int left = 0, right = left + 1, max = 1;
        while(right < nums.length){
            if(nums[right] <= nums[right - 1]){
                left = right;
            }
            right ++;
            max = Math.max(right - left, max);
        }
        return max;
    }
}