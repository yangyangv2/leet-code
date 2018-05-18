package prob050.pow;

/**
 * Created by yanya04 on 8/16/2017.
 * Modified by yanya04 on 5/14/2018.
 * Modified by yanya04 on 5/16/2018.
 */
public class Solution {

    /*
        9:          1001
        x ^ 9 = x ^ 8 * x ^ 1
    */

    public double myPow(double x, int n) {
        long pow = (long)n;
        if(pow < 0) {
            x = 1 / x;
            pow = - pow;
        }
        double res = 1;
        while(pow > 0){
            if((pow & 1) == 1)
                res *= x;
            pow = pow >> 1;
            x *= x;
        }
        return res;
    }
}
