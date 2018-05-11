package prob398.random.pick.index;

import java.util.Random;

/**
 *  Created by yanya04 on 5/11/2018.
 */
public class Solution {

    int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        Random rand = new Random();
        int random = -1, count = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == target){
                random = (rand.nextInt(++ count) == 0)? i : random;
            }
        }
        return random;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */