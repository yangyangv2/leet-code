package prob016.three.sum.closest;

import java.util.Arrays;

/**
 * Created by yanya04 on 7/23/2017.
 * Modified by yanya04 on 5/1/2017.
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;

        int min = Integer.MAX_VALUE, res = 0, n = nums.length;
        Arrays.sort(nums);
        int lo = 0, hi = 0, dist = 0, sum = 0;
        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            lo = i + 1;
            hi = n - 1;
            while(lo < hi){
                if(lo > i + 1 && nums[lo] == nums[lo - 1]) {lo ++; continue; }
                if(hi < n - 1 && nums[hi] == nums[hi + 1]) {hi --; continue; }

                sum = nums[i] + nums[lo] + nums[hi];

                if(sum == target){
                    return sum;
                } else if(sum < target){
                    lo ++;
                } else {
                    hi --;
                }

                dist = Math.abs(sum - target);
                if(dist < min){
                    res = sum;
                    min = dist;
                }

            }
        }
        return res;
    }
}