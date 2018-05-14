package prob050.pow;

/**
 * Created by yanya04 on 8/16/2017.
 * Modified by yanya04 on 5/14/2018.
 */
public class Solution {
    /*
    // edge case

    // optimization

        a ^ 9
        9 = 2 ^ 3 + 1

        a ^ 9 = a ^ 8 * a ^ 1

        a * a ^ 8

        a ^ 8 = (a ^ 4) ^ 2 = (((a ^ 2) ^ 2) ^ 2)

        a ^ 3 = (a ^ 2) * a

    */
    public double myPow(double x, int n) {
        double res = 1;
        long bigN = Math.abs((long) n);
        /*
        for(long i = 0; i < bigN; i ++){
            res *= x;
        }*/

        while(bigN > 0){
            if( bigN % 2 == 1)
                res *= x;
            bigN = bigN >> 1;
            x *= x;
        }

        return (n < 0) ? 1 / res: res;
    }
}
