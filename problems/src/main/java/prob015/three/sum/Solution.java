package prob015.three.sum;

import java.util.*;

/**
 * Created by yanya04 on 7/22/2017.
 * Modified by yanya04 on 5/1/2018.
 * Modified by yanya04 on 5/18/2018.
 */
public class Solution {
    /*
        a + b + c = 0
        a + b = -c

        // sort it?

        -4, -1, -1, 0, 1, 2
         4
    */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        int sum = 0, lo = 0, hi = 0, temp = 0;
        for(int i = 0; i < nums.length; i ++){
            lo = i + 1; hi = nums.length - 1;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            while(lo < hi){
                sum = nums[i] + nums[lo] + nums[hi];
                if(sum == 0){
                    res.add(new ArrayList<>(Arrays.asList(new Integer[]{nums[i], nums[lo], nums[hi]})));
                    while(lo + 1 < hi && nums[lo] == nums[lo + 1]) lo ++;
                    while(lo + 1 < hi && nums[hi] == nums[hi - 1]) hi --;
                    lo ++; hi --;
                } else if(sum > 0){
                    hi --;
                } else {
                    lo ++;
                }
            }
        }
        return res;
    }
}