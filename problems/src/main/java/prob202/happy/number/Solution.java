package prob202.happy.number;

/**
 * Created by yanya04 on 8/9/2017.
 */
public class Solution {

    public boolean isHappy(int n) {
        int fast = n, slow = n;
        do{
            fast = calHappy(fast);
            fast = calHappy(fast);
            slow = calHappy(slow);
        } while( fast != slow);
        return fast == 1;
    }


    private int calHappy(int n){

        int c = n, sum = 0;
        while(c > 0){
            sum += Math.pow(c % 10, 2);
            c /= 10;
        }

        return sum;
    }
}
