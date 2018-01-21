package prob233.number.of.digit.one;

/**
 * Created by yanya04 on 1/20/2018.
 */
public class Solution {
/*
    for digit 1

    0~10	1
    0~100	10
    0~1000	100

    for digit 2

    0~10	0
    0~100	1
    0~1000	10

    ...


    24             10   1

     1             10   3
     2
     3
     4             13 =>
     5
     6             1. left = 1, right = 0, digit = 3 => (1 + 1) = 2
     7             2. left = 0, right = 3, digit = 1 => 0 * 10 + 3 = 3 ===> 5
     8
     9            24 =>
    10             1. left = 2, right = 0, digit = 4 => (2 + 1) * 1 = 3
    11             2. left = 0, right = 4, digit = 2 => (0 + 1) * 10 = 10 ===> 13
    12
    13           133 =>
    14             1. left = 13, right = 0, digit = 3 => (13 + 1) * 1 = 14
    15             2. left = 1, right = 3, digit = 3 =>  (1 + 1) * 10 = 20
    16             3, left = 0, right = 33, digit = 1 => 0 * 100 + 33 + 1 = 34
    17
    18
    19
    20
    21
    22
    23
    24

*/

    public int countDigitOne(int n) {
        long res = 0;
        if(n <= 0) return 0;
        else if(n == 1) return 1;



        for(long i = 1; i <= n; i *= 10){
            long left = n / (i * 10);
            long right = n % i;
            long digit = (n / i) % 10;

            if(digit == 0){
                res += left * i;
            } else if(digit == 1){
                res += left * i + right + 1;
            } else {
                res += (left + 1) * i;
            }
        }
        return (int)res;
    }
}