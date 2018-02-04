package prob292.nim.game;

/**
 * Created by yanya04 on 2/3/2018.
 */
public class Solution {

    /*
        DP

        f(0) true
        f(1) true
        f(2) true
        f(3) true
        f(4) false
        f(5) true
        f(6) true
        f(7) true

        whoever deals a hand of multiple 4 will loss
    */


    public boolean canWinNim(int n) {

        // if my turn
        return (n & 0b11) != 0;

    }
}
