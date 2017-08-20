package prob367.valid.perfect.square;

/**
 * Created by yanya04 on 8/19/2017.
 */
class Solution {

    /*
        1.  brute force
        2.  binary
    */

    public boolean isPerfectSquare(int num) {


        int factor = 1;
        int base = 0;

        int sum = factor + base;
        while(sum <= num / sum){

            if(sum == num /sum && num % sum == 0){
                return true;
            }

            factor *= 2;
            sum = base + factor;

            if(sum > num / sum){
                base += factor / 2;
                factor = 1;
                sum = base + factor;
            }
        }
        return false;
    }
}
