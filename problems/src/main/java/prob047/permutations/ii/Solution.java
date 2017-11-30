package prob047.permutations.ii;

import java.util.List;

/**
 * Created by yanya04 on 7/23/2017.
 */

import java.util.ArrayList;
import java.util.Arrays;


public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permuteUnique(new int[]{1, 1, 2}));

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(list, new ArrayList<Integer>(), used, nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> temp, boolean[] used, int[] nums){
        if(temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
        } else {
            for(int i = 0; i < nums.length; i ++){
                if(used[i]) continue;
                if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                temp.add(nums[i]);
                backtrack(list, temp, used, nums);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }
}
