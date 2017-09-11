package prob462.minimum.moves.to.equal.array.elements.ii;

import java.util.Arrays;

/**
 * Created by yanya04 on 9/11/2017.
 */
public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int moves = 0;
        while(i < j){
            moves += (nums[j] - nums[i]);
            j --; i ++;
        }
        return moves;
    }
}
