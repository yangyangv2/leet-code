package prob231.power.of.two;

/**
 * Created by yanya04 on 8/31/2017.
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {

        int x = 1;

        while(x < n && x > 0){
            x = x << 1;
        }

        if(x == n){
            return true;
        }  else {
            return false;
        }
    }
}