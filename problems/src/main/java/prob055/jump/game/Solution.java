package prob055.jump.game;

/**
 * Modified by yanay04 on 4/26/2018.
 * Modified by yanya04 on 6/2/2018.
 */
public class Solution {
    public boolean canJump(int[] nums) {
        return greedy(nums);
        // return dp(nums);
    }


    public boolean greedy(int[] nums) {
        int max = 0, n = nums.length;
        for(int i = 0; i < n; i ++){
            if(max < i) break;
            max = Math.max(i + nums[i], max);
            if(max >= n - 1) return true;
        }
        return false;
    }


    /*
        [2,3,1,1,4]
         T T T T T

        [3,2,1,0,4]
         T T T T F
    */
    private boolean dp(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return true;

        int n = nums.length;
        boolean[] can = new boolean[n];

        if(nums[0] >= 0){
            can[0] = true;
        }

        for(int end = 1; end < n; end ++){
            for(int start = 0; start < end; start ++){
                if(can[start] && nums[start] >= end - start){
                    can[end] = true;
                    break;
                }
            }
        }

        return can[n - 1];

    }
}