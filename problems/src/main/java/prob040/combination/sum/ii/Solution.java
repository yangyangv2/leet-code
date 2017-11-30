package prob040.combination.sum.ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // duplicate allowed
    // can't use the same elements

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] candidates, int target, int sum, int start){
        if(sum == target) list.add(new ArrayList<Integer>(temp));
        if(sum > target) return;
        for(int i = start; i < candidates.length; i ++){
            if(i > start && candidates[i] == candidates[i - 1]) continue;
            sum += candidates[i];
            temp.add(candidates[i]);
            backtrack(list, temp, candidates, target, sum, i + 1);
            temp.remove(temp.size() - 1);
            sum -= candidates[i];
        }
    }

}