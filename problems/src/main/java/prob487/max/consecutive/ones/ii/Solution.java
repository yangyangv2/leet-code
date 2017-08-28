package prob487.max.consecutive.ones.ii;

/**
 * Created by yanya04 on 8/27/2017.
 */
public class Solution {

/*
    0 0 0 1 1 1 1 1 1 0 1 1 1 1 1 0 1 1
          left
                        right

*/

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int left = 0, right = 0;


        for(int i = 0; i < nums.length; i ++){
            right ++;
            if(nums[i] == 0){
                left = right;
                right = 0;
            }
            max = Math.max(left+right + 1, max);
        }


        return max;
    }
}
