package prob477.total.hamming.distance;

/**
 *  Created by yanya04 5/19/2018.
 */
public class Solution {
    public int totalHammingDistance(int[] nums) {

        int res = 0, bits = 0, n = nums.length;
        for(int i = 0; i < 32; i ++){
            bits = 0;
            for(int j = 0; j < nums.length; j ++){
                if(((nums[j] >>> i) & 1) == 1){
                    bits ++;
                }
            }
            // bits 1s & (n - bits) bits 0s.
            // they will generate in totall bits * (n - bits) distance
            res += bits * (n - bits);
        }
        return res;
    }
}