package prob491.increasing.subsequences;

import java.util.*;

public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {

        Set<List<Integer>> list = new HashSet<>();

        if(nums == null || nums.length < 0) return new ArrayList<List<Integer>>(list);

        helper(list, nums, 0, new ArrayDeque<Integer>());

        return new ArrayList<List<Integer>>(list);
    }

    private void helper(Set<List<Integer>> list, int[] nums, int index, Deque<Integer> holder){

        if(holder.size() > 1){
            list.add(new ArrayList<>(holder));
        }

        for(int i = index; i < nums.length; i ++){
            if(holder.isEmpty() || holder.getLast() <= nums[i]){
                holder.offer(nums[i]);
                helper(list, nums, i + 1, holder);
                holder.removeLast();
            }
        }
    }
}