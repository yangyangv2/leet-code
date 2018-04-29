package prob045.jump.game.ii;

import java.util.Arrays;

/**
*   Modified by yanya04 on 4/26/2018.
 */
public class Solution {

    /*
                [2,3,1,1,4]
   min steps    [0,1,1,2,2]

                [2,9,1,1,1,1,1]
    max          2,9,9,9,9,9,9
    count        0 1,2,2,2,2,2

                [2,3,1,1,4]
    max          2,4,4,4,4
    count      0,1,2,2,2


    */

    public int jump(int[] nums) {
        //return dp(nums);
        return greedy(nums);
    }

    private int greedy(int[] nums){
        int n = nums.length, max = 0, border = 0, count = 0;
        for(int i = 0; i < n - 1; i ++){
            max = Math.max(max, i + nums[i]);
            if(border == i){
                count ++;
                border = max;
            }
        }
        return count;
    }


    private int dp(int[] nums){
        int n = nums.length;
        if(n < 2) return 0;

        int[] ms = new int[n];
        Arrays.fill(ms, Integer.MAX_VALUE);

        ms[0] = 0;
        for(int end = 1; end < n; end ++){
            for(int start = 0; start < end; start ++){
                if(start + nums[start] >= end){
                    ms[end] = Math.min(ms[start] + 1, ms[end]);
                }
            }
        }
        return ms[n - 1];
    }
}