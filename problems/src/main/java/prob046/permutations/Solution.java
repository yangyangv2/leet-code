package prob046.permutations;

import java.util.*;

/**
 * Created by yanya04 on 7/23/2017.
 * Modified by yanya04 on 5/2/2018.
 * Modified by yanya04 on 5/14/2018.
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        backtrack(res, new LinkedHashSet<Integer>(), nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, Set<Integer> set, int[] nums){
        if(set.size() == nums.length){
            res.add(new ArrayList<>(set));
            return;
        }
        for(int i = 0; i < nums.length; i ++){
            if(set.contains(nums[i]))
                continue;
            set.add(nums[i]);
            backtrack(res, set, nums);
            set.remove(nums[i]);
        }
    }
}