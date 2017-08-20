package prob633.sum.of.square.numbers;

/**
 * Created by yanya04 on 8/19/2017.
 */
class Solution {

/*
    a^2 + b^2 = target
*/

    public boolean judgeSquareSum(int c) {

        int a = 0, b = (int)Math.sqrt(c);

        int factor = 1;
        while(a <= b){
            int result = a * a + b * b;
            if(result == c){
                return true;
            } else if(result > c){
                b --;
                a = (int)Math.sqrt(c - b * b);
            } else {
                // a ++;
                //
                // a *= 2
                a ++;
            }
        }
        return false;
    }
}
