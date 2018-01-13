package prob191.number.of.one.bits;

/**
 * Created by yanya04 on 1/13/2018.
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {


        return hammingWeigth2(n);
    }


    private int hammingWeigth1(int n){
        int res = 0;
        for(int i = 0; i < 32; i++){
            if((n & 1) == 1)
                res ++;
            n = n >> 1;
        }
        return res;
    }

    /*
        n & (n - 1) remove the right most 1 from n
    */
    private int hammingWeigth2(int n){

        int res = 0;
        while(n != 0){
            n = n & (n - 1);
            res ++;
        }

        return res;
    }
}
