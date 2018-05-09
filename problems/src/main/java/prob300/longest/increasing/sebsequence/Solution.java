package prob300.longest.increasing.sebsequence;

import java.util.Arrays;

/**
 * Created by yanya04 on 8/27/2017.
 * Modified by yanya04 on 5/7/2018.
 */
public class Solution {
    /*
        f[i], LIS ends with char[i];
        iterate and keep the longest distance
    */

    private int dp(int[] nums){
        int n = nums.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);

        for(int i = 0; i < n; i ++){
            for(int j = 0; j <= i; j ++){
                if(nums[j] < nums[i]){
                    f[i] = Math.max(f[j] + 1, f[i]);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < n; i ++){
            max = Math.max(max, f[i]);
        }
        return max;
    }


    private int binary(int[] nums){
        int n = nums.length;
        int[] maxarr = new int[n];
        int index = 0, level = 0;
        for(int i = 0; i < n; i ++){
            index = Arrays.binarySearch(maxarr, 0, level, nums[i]);
            index = index < 0 ? -(index + 1): index;
            if(index == level) level ++;
            maxarr[index] = nums[i];
        }
        return level;
    }

    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        return binary(nums);
    }
}
