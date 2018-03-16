package prob319.bulb.switcher;

/**
 * Created by yanya04 on 3/7/2018.
 */
public class Solution {
    /*
        n = 5
        0 = 0 0 0 0 0
        1 = 1 1 1 1 1
        2 = 1 0 1 0 1
        3 = 1 0 0 0 1
        4 = 1 0 0 1 1
        5 = 1 0 0 1 0   = 2

        n = 6
            1 2 3 4 5 6
        0 = 0 0 0 0 0 0
        1 = X X X X X X
        2 = 1 X 1 X 1 X
        3 = 1 0 X 0 1 X
        4 = 1 0 0 X 1 1
        5 = 1 0 0 1 X 1
        6 = 1 0 0 1 0 X = 2

        k(i) = number of common factors

    */
    public int bulbSwitch(int n) {

        return (int)Math.sqrt(n);
    }

}