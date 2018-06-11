package prob015.three.sum;

import java.util.*;

/**
 * Created by yanya04 on 7/22/2017.
 * Modified by yanya04 on 5/1/2018.
 * Modified by yanya04 on 5/18/2018.
 * Modified by yanya05 on 6/10/2018.
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>  res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n; i ++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int lo = i + 1, hi = n - 1;
            while(lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                if(sum == 0) {
                    res.add(Arrays.asList(new Integer[]{nums[i], nums[lo], nums[hi]}));
                    lo ++; hi --;
                }
                else if(sum < 0) lo ++;
                else hi --;

                while(lo > i + 1 && lo < hi && nums[lo] == nums[lo - 1]) lo ++;
                while(hi > n - 1 && hi > lo && nums[hi] == nums[hi - 1]) hi --;
            }
        }
        return res;
    }
}