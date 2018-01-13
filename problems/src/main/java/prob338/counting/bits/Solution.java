package prob338.counting.bits;

/**
 * Created by yanya04 on 1/13/2018.
 */
public class Solution {
/*
          i     i & (i - 1)
    0   0000    0000    0
    1   0001    0000    0
    2   0010    0000    0
    3   0011    0010    2
    4   0100    0000    0
    5   0101    0100    4
    6   0110    0100    4
    7   0111    0110    6


*/

    public int[] countBits(int num) {

        int[] res = new int[num + 1];

        for(int i = 1; i <= num; i ++){
            res[i] = res[i & (i - 1)] + 1;
        }

        return res;
    }
}