package prob461.hamming.distance;

/**
 *  Modified by yanya04 5/19/2018.
 */
public class Solution {
    public int hammingDistance(int x, int y) {

        return Integer.bitCount(x ^ y);

    }
}