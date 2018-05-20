package prob487.max.consecutive.ones.ii;

/**
 * Created by yanya04 on 8/27/2017.
 * Modified by yanya04 on 5/20/2018.
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int start = 0, end = 0, max = 0;
        int zeros = 0;
        while(end < nums.length){
            if(nums[end++] == 0)
                zeros ++;

            while(zeros > 1){
                if(nums[start++] == 0)
                    zeros--;
            }

            max = Math.max(max, end - start);
        }
        return max;
    }
}