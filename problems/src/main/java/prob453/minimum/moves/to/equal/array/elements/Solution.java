package prob453.minimum.moves.to.equal.array.elements;

/**
 * Created by yanya04 on 9/11/2017.
 */
public class Solution {
    public int minMoves(int[] nums) {

        if(nums.length == 0) return 0;

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            min = Math.min(nums[i], min);
        }

        int moves = 0;
        for(int i = 0; i < nums.length; i ++){
            moves += (nums[i] - min);
        }

        return moves;
    }
}
