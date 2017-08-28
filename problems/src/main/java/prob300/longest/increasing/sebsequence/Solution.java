package prob300.longest.increasing.sebsequence;

import java.util.Arrays;

/**
 * Created by yanya04 on 8/27/2017.
 */
public class Solution {

    /*
        solution 1, dynamic programming
    */

    public int lengthOfLIS(int[] nums) {

        int[] lens = new int[nums.length];
        Arrays.fill(lens, 1);

        for(int i = 1; i < nums.length; i ++){
            for(int j = 0; j < i; j ++){
                if(nums[j] < nums[i]){
                    lens[i] = Math.max(lens[j] + 1, lens[i]);
                }
            }
        }

        int maxLen = Integer.MIN_VALUE;

        for(int i = 0; i < lens.length;i ++){
            maxLen = Math.max(maxLen, lens[i]);
        }

        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }

}
