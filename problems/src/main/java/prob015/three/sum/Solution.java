package prob015.three.sum;

import java.util.*;

/**
 * Created by yanya04 on 7/22/2017.
 * Modified by yanya04 on 5/1/2018.
 */
public class Solution {

    /*
        O(n^2)

        sum = a + b + c = 0
        no duplicates
    */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;

        Arrays.sort(nums);
        int n = nums.length, lo = 0, hi = 0, sum = 0;
        // loop1: iterate 'a'
        for(int i = 0; i < n; i ++){

            // remove duplicates
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            // b & c
            lo = i + 1;
            hi = n - 1;
            while(lo < hi){

                if(lo > i + 1 && nums[lo] == nums[lo - 1]) { lo ++; continue; }
                if(hi < n - 1 && nums[hi] == nums[hi + 1]) { hi --; continue; }

                sum = nums[i] + nums[lo] + nums[hi];
                if(sum == 0){
                    res.add(Arrays.asList(new Integer[]{nums[i], nums[lo], nums[hi]}));
                    lo ++; hi --;
                } else if (sum < 0){
                    lo ++;
                } else {
                    hi --;
                }
            }
        }

        return res;
    }
}