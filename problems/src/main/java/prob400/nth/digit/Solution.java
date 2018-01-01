package prob400.nth.digit;

public class Solution {


    /*
        0 - 9 10 - 99 100 - 999
        |-1-| |--2--| |--3----|  .....
    */
    public int findNthDigit(int n) {

        int len = 1;
        long count = 9;
        int base = 1;

        // n = 21

        while(n > len * count){
            n -= count * len;
            count *= 10;
            base *= 10;
            len ++;
        }
        // n = 12;
        // base = 10;
        // len = 2;

        base += (n - 1) / len;
        return String.valueOf(base).charAt( (n - 1) % len) - '0';

    }
}