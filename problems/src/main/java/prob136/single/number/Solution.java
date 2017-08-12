package prob136.single.number;

/**
 * Created by yanya04 on 8/9/2017.
 */
public class Solution {

/*
    Solution1 1: use a map, O(n), O(n)

    Solution1 2: use XOR

                A XOR 0 = A
                A XOR A = 0
*/

    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i ++){
            result ^= nums[i];
        }
        return result;
    }
}
