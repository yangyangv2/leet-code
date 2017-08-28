package prob485.max.consecutive.ones;

/**
 * Created by yanya04 on 8/27/2017.
 */
public class Solution {


    /*
        0 1 0 1 1 0 1 0 1 1 1 1 0 1

    */
    public int findMaxConsecutiveOnes(int[] nums) {

        int max = 0;
        int ones = 0;
        for(int i = 0; i < nums.length; i ++){
            ones ++;
            if(nums[i] == 0){
                ones = 0;
            }
            max = Math.max(ones, max);
        }
        return max;
    }
}
