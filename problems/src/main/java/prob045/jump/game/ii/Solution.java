package prob045.jump.game.ii;

public class Solution {
    /*
    i           0 1 2 3 4
    num         2 0 1 0 4
    max       0 2 2 3 3
    count     0 1 1 2 3
    end       0 2 2 3 3

    */
    public int jump(int[] nums) {

        int n = nums.length;
        int end = 0, max = 0, count = 0;
        for(int i = 0; i < n - 1; i ++){
            max = Math.max(max, i + nums[i]);
            if(i == end){
                count ++;
                end = max;
            }
        }
        return count;
    }
}