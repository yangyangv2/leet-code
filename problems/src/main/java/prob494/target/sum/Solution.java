package prob494.target.sum;

import java.util.HashMap;
import java.util.Map;

/**
 *  Created by yanya04 on 5/9/2018.
 *  Modified by yanya04 on 6/2/2018.
 */
public class Solution {
    /*
        Input: nums is [1, 1, 1, 1, 1], S is 3.
        Output: 5
        Explanation:

        -1+1+1+1+1 = 3
        +1-1+1+1+1 = 3
        +1+1-1+1+1 = 3
        +1+1+1-1+1 = 3
        +1+1+1+1-1 = 3

        bruteforce + memo

    */
    public int findTargetSumWays(int[] nums, int S) {

        int[][] memo = new int[20][2000];

        return count(nums, 0, 0, S, memo);
    }


    private int count(int[] nums, int start, int value, int target, int[][] memo){

        if(start == nums.length){
            return value == target ? 1: 0;
        }


        if(memo[start][value + 1000] > 0) return memo[start][value + 1000];

        int count = 0;

        count += count(nums, start + 1, value + nums[start], target, memo);

        count += count(nums, start + 1, value - nums[start], target, memo);

        memo[start][value + 1000] = count;

        return count;
    }
}