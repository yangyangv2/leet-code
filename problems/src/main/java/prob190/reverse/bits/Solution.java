package prob190.reverse.bits;

/**
 * Created by yanya04 on 1/13/2018.
 * Modified by yanya04 on 5/25/2018.
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;

        for(int i = 0; i < 32; i ++){
            res = res << 1;
            res |= (n & 1);
            n = n >>> 1;
        }
        return res;
    }
}
