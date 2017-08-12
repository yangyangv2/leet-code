package prob046.permutations;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yanya04 on 7/23/2017.
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permute(new int[]{1,2,3}));
    }

        /*
        Questions:

        1. handle null?

        Solution1

        1. recursive
        2. avoid duplicate?

    */

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);

        if(nums == null) return result;

        traverse(nums, used, new LinkedList<>(), result);

        return result;

    }

    private void traverse(int[] nums, boolean[] used, List<Integer> trackList, List<List<Integer>> result){
        for(int i = 0; i < nums.length; i ++){
            // skip used numbers;
            if(used[i]) continue;

            if(trackList.size() == nums.length - 1){
                // last entry:
                List<Integer> list = new ArrayList<>(trackList);
                list.add(nums[i]);
                result.add(list);
            } else {
                // on the traverse path
                used[i] = true;
                trackList.add(nums[i]);
                traverse(nums, used, trackList, result);
                trackList.remove(trackList.size() - 1);
                used[i] = false;
            }
        }
    }
}
