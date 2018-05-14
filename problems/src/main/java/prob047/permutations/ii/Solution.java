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
 * Modified by yanya04 on 5/14/2018.
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;

        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(res, nums, visited, new ArrayList<>());

        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, boolean[] visited, List<Integer> list){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return ;
        }

        /*
        used    t t t
                1 1 2

                1 1 2
        1           i
        2         i
        3

        used    t   t
                2 1 1
        */

        for(int i = 0; i < nums.length; i ++){
            if(visited[i]) continue;
            if(i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) continue;
            visited[i] = true;
            list.add(nums[i]);
            backtrack(res, nums, visited, list);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
