package prob268.missing.number;

/**
 * Created by yanya04 on 8/13/2017.
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;
        for(int i = 0; i < nums.length; i ++){
            xor = xor ^ nums[i] ^ i;
        }
        return xor ^ nums.length;
    }
}
