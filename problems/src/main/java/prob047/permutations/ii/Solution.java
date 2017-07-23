package prob047.permutations.ii;

import java.util.List;

/**
 * Created by yanya04 on 7/23/2017.
 */

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;


public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permuteUnique(new int[]{1,1,2}));

    }

    /*
        Solution:

        1. sort
        2. skip duplicate


    */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if(nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);

        traverse(nums, used, new ArrayList<Integer>(nums.length), result);
        return result;
    }


    private void traverse(int[] nums, boolean[] used, List<Integer> trackList, List<List<Integer>> result){
        for(int i = 0; i < nums.length; i ++){
            if(used[i]) continue;                                        // skip used
            if(trackList.size() == nums.length - 1){
                // last entry:
                List<Integer> list = new ArrayList<>(trackList);
                list.add(nums[i]);
                result.add(list);
            } else {
                used[i] = true;
                trackList.add(nums[i]);
                traverse(nums, used, trackList, result);
                trackList.remove(trackList.size() - 1);
                used[i] = false;
            }
            while(i < nums.length - 1 && nums[i] == nums[i + 1]) i ++; // skip duplicate
        }
    }
}
