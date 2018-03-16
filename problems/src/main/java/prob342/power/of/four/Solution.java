package prob342.power.of.four;

/**
 * Created by yanya04 on 3/8/2018.
 */
public class Solution {
    public boolean isPowerOfFour(int num) {
        // return recursive(num);
        return nonresurcive(num);
    }

    private boolean recursive(int num){
        if(num <= 0) return false;
        if(num == 1) return true;
        return num % 4 == 0 && recursive(num / 4);
    }

    /*
        X = 4 ^ N

        N = log(X) / log(4)
        N has to be integer

    */
    private boolean nonresurcive(int num){

        double val = Math.log(num) / Math.log(4);
        return val % 1 == 0;

    }
}