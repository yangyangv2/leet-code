package prob016.three.sum.closest;

import java.util.Arrays;

/**
 * Created by yanya04 on 7/23/2017.
 * Modified by yanya04 on 5/1/2018.
 * Modified by yanya04 on 5/18/2018.
 */
public class Solution {
    /*
        a + b + c = target
        sort
        pick any number for a
        find remaining, track the closest
    */
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE, sum = 0, res = 0, n = 0, lo = 0, hi = 0;
        if(nums == null || nums.length < 3) return -1;
        n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n; i ++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            lo = i + 1; hi = n - 1;
            while(lo < hi){
                sum = nums[i] + nums[lo] + nums[hi];
                if(target == sum){
                    return sum;
                } else if(target > sum){
                    lo ++;
                    while(lo < hi && nums[lo] == nums[lo - 1]) lo ++;
                } else {
                    hi --;
                    while(lo < hi && nums[hi] == nums[hi + 1]) hi --;
                }
                if(Math.abs(sum - target) < diff){
                    diff = Math.abs(sum - target);
                    res = sum;
                }
            }
        }
        return res;
    }
}