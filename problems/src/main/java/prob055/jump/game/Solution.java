package prob055.jump.game;

import java.util.Arrays;

public class Solution {
    private boolean canjump(int[] nums, int pos){
        if(pos >= nums.length - 1) return true;
        int max = nums[pos];
        for(int i = 1; i <= max; i ++){
            if(canjump(nums, pos + i))
                return true;
        }
        return false;
    }

    //  naive backtrack approach
    private boolean backtrack(int[] nums){
        // can jump from 0
        // can jump from i
        // can jump from ???
        return canjump(nums, 0);
    }


    private boolean canjump(int[] nums, int[] bottomup, int pos){
        if(pos == nums.length - 1) return true;
        int max = nums[pos];
        for(int i = 1; i <= max; i ++){
            int maxpos = Math.min(pos + i, nums.length - 1);
            if(bottomup[maxpos] != -1)
                return bottomup[maxpos] == 1? true: false;
            if(canjump(nums, bottomup, maxpos)){
                bottomup[maxpos] = 1;
                return true;
            }
        }
        bottomup[pos] = 0;
        return false;
    }

    //  bottom up DP approach with memory table
    private boolean bottomup(int [] nums){

        if(nums.length == 0) return true;

        int[] bottomup = new int[nums.length];
        Arrays.fill(bottomup, -1);

        // TODO, convert to enum later
        // -1 unknown
        // 0  bad
        // 1 good

        bottomup[0] = 1;
        return canjump(nums, bottomup, 0);
    }


    private boolean topdown(int[] nums){

        if(nums.length == 0) return true;
        int[] topdown = new int[nums.length];
        Arrays.fill(topdown, -1);
        topdown[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i --){
            int furthest = Math.min(i + nums[i], nums.length - 1);
            for(int j = furthest; j > i; j--){
                if(topdown[j] == 1){
                    topdown[i] = 1;
                    break;
                }
            }
        }
        return topdown[0] == 1;
    }


    private boolean greedy(int[] nums){
        int furthest = 0;
        for(int i = 0; i < nums.length ; i ++){
            if(furthest < i) break;
            furthest = Math.max(furthest, i + nums[i]);
        }
        return furthest >= nums.length - 1;
    }

    public boolean canJump(int[] nums) {
        // will get Time Limit Exceeded at 73/75
        // return backtrack(nums);
        // will get StackOverFlow at 73/75
        // return bottomup(nums);
        // will get Time Limit Exceeded at 75/75
        // return topdown(nums);

        // the greedy passed eventually
        return greedy(nums);
    }
}