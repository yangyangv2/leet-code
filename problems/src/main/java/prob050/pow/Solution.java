package prob050.pow;

/**
 * Created by yanya04 on 8/16/2017.
 */
public class Solution {
    public double myPow(double x, int n) {

        // if n == Integer.MIN_VALUE... then cast to long

        if( n == Integer.MIN_VALUE){
            return 1 / pow(x, Math.abs((long)n));
        }
        if(n < 0) return 1/pow(x, Math.abs(n));
        else return pow(x, n);
    }

    private double pow(double x, long n){
        double val = 1;
        long c = 0;
/*
        1. handle 0 and negative
        2. 1 2 4 8 16 => 15 break at 16;
             1 2 4    => 8 + 7 reach at 7;

        case 1: n = 0;
        case 2: n = 1;
        case 3: n = 5;

*/
        while(c < n){
            long i = 1;
            double v = x;
            while(c + i * 2 < n){
                i *= 2;
                v *= v;
            }
            val *= v;
            c += i;
        }
        return val;
    }

}
