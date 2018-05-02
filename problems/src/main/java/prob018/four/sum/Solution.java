package prob018.four.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

/**
 * Created by yanya04 on 7/23/2017.
 * Modified by yanya04 on 5/1/2018.
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int lo = 0, hi = 0, sum = 0;
        for(int i = 0; i < n; i ++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < n; j ++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                lo = j + 1; hi = n - 1;
                while(lo < hi){
                    if(lo > j + 1 && nums[lo] == nums[lo - 1 ]) {lo ++; continue; }
                    if(hi < n - 1 && nums[hi] == nums[hi + 1 ]) {hi --; continue; }
                    sum = nums[i] + nums[j] + nums[lo] + nums[hi];
                    if(sum == target){
                        res.add(Arrays.asList(new Integer[]{nums[i], nums[j], nums[lo], nums[hi]}));
                        lo ++; hi --;
                    } else if(sum < target){
                        lo ++;
                    } else {
                        hi --;
                    }
                }
            }
        }
        return res;
    }
}
