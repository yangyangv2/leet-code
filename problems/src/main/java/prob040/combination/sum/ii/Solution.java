package prob040.combination.sum.ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Modified by yanya04 on 5/15/2018.
 */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, new ArrayList<Integer>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int start, int target, List<Integer> list, List<List<Integer>> res){

        if(target < 0)
            return;
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < candidates.length; i ++){

            if(i > start && candidates[i] == candidates[i - 1])
                continue;

            list.add(candidates[i]);
            backtrack(candidates, i + 1, target - candidates[i], list, res);
            list.remove(list.size() - 1);
        }
    }
}