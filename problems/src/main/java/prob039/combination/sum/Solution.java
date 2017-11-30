package prob039.combination.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<Integer>(), 0, target, candidates, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> temp, int sum, int target, int[] candidates, int start){

        if(sum == target) list.add(new ArrayList<Integer>(temp));
        if(sum > target) return;
        for(int i = start; i < candidates.length; i ++){
            temp.add(candidates[i]);
            sum += candidates[i];
            backtrack(list, temp, sum, target, candidates, i);
            sum -= candidates[i];
            temp.remove(temp.size() - 1);
        }
    }

}