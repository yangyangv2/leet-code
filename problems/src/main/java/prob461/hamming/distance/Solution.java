package prob461.hamming.distance;

public class Solution {
    public int hammingDistance(int x, int y) {

        int dist = 0;
        int xor = x ^ y;
        while(xor > 0){
            dist += (xor & 1);
            xor = xor >>> 1;
        }
        return dist;

    }
}