package prob029.divide.two.integers;

/**
 * Created by yanya04 on 8/14/2017.
 */
public class Solution {
    public int divide(int dividend, int divisor) {

        if(divisor == 0) throw new IllegalArgumentException("divisor is zero");
        long dvd = Math.abs((long)dividend), dvs = Math.abs((long)divisor);
        long result = 0, remain = dvd;

        while(remain >= dvs){
            long shift = 1, cur = dvs;
            while(remain - cur >= 0){
                shift = shift << 1;
                cur = cur << 1;
            }
            shift = shift >> 1;
            result += shift;
            remain -= cur >> 1;
        }


        int sign = 1;
        if(dividend < 0) sign *= -1;
        if(divisor < 0) sign *= -1;

        if(result == Math.abs((long)Integer.MIN_VALUE) && sign == 1){
            return Integer.MAX_VALUE;
        } else {
            return (int) (sign * result);
        }

    }
}
