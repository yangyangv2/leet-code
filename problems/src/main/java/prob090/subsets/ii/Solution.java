package prob090.subsets.ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int start){
        list.add(new ArrayList<Integer>(temp));
        for(int i = start; i < nums.length; i ++){
            if(i > start && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            backtrack(list, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}