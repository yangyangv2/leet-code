package prob047.permutations.ii;

import java.util.List;

/**
 * Created by yanya04 on 7/23/2017.
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yanya04 on 7/23/2017.
 * Modified by yanya04 on 5/2/2018.
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), used, nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> temp, boolean[] used, int[] nums){

        if(temp.size() == nums.length){
            list.add(new ArrayList<Integer>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i ++){
            if(used[i]) continue;
            if(i > 0 && !used[i - 1] && nums[i - 1] == nums[i]) continue;
            used[i] = true;
            temp.add(nums[i]);
            backtrack(list, temp, used, nums);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
