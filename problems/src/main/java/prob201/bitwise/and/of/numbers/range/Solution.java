package prob201.bitwise.and.of.numbers.range;

/**
 * Created by yanya04 on 1/18/2018.
 */
public class Solution {

/*
    5   0101
    6   0100
    7   0111
-------------
        0100



        0001
        0010
        0011
        0100
        0101
        0110
        0111
        1000
        1001
        1010
        1011
        1100
        1101
        1110
        1111

*/

    public int rangeBitwiseAnd(int m, int n) {


        int offset = 0;
        while(m < n){
            m >>= 1;
            n >>= 1;
            offset ++;
        }

        return n << offset;
    }
}