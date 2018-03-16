package prob326.power.of.three;

/**
 * Created by yanya04 on 3/8/2018.
 */
public class Solution {

    public boolean isPowerOfThree(int n) {

        //return recursive(n);
        return norecursive(n);
    }

    private boolean recursive(int n){
        if(n <= 0) return false;
        if(n == 1) return true;
        return n % 3 == 0 && recursive(n / 3);
    }

    private boolean norecursive(int n){
        /*
            X is a power of 3 then

            X = 3 ^ N
            N = log(X) / log(3)
            N is an integer
        */

        double res = Math.log(n) / Math.log(3);

        double diff = Math.abs(res - Math.round(res));

        return diff < Math.pow(10, -14);


    }
}