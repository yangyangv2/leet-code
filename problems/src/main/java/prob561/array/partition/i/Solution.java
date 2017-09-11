package prob561.array.partition.i;

import java.util.Arrays;

/**
 * Created by yanya04 on 9/10/2017.
 */
public class Solution {

/*
Consider the smallest element x. It should be paired with the next smallest element,
because min(x, anything) = x, and having bigger elements only helps you have a larger score. Thus, we should pair adjacent elements together in the sorted array.
 */
    // sort

    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i +=2){
            sum += nums[i];
        }

        return sum;
    }
}
