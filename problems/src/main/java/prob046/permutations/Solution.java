package prob046.permutations;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yanya04 on 7/23/2017.
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums){

        if(temp.size() == nums.length)
            list.add(new ArrayList<Integer>(temp));

        for(int i = 0; i < nums.length; i ++){
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            backtrack(list, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }
}
