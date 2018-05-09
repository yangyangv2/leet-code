package prob213.house.robber.ii;

import java.util.Arrays;

/**
 *  Modified by yanya04 on 5/7/2018.
 */
public class Solution {

    // Max(steal the first + [2~end - 1], dont' still the first + [1, end]);

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        return Math.max(gain(nums, 2, nums.length - 2) + nums[0], gain(nums, 1, nums.length - 1));
    }

    private int gain(int[] nums, int start, int stop){
        int[] gain = new int[2];
        for(int i = start; i <= stop; i ++){
            gain[(i + 1) % 2] = Math.max(gain[(i - 1) % 2] + nums[i], gain[i % 2]);
        }
        return Math.max(gain[0], gain[1]);
    }
}