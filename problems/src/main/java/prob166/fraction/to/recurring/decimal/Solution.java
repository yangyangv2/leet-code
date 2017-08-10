package prob166.fraction.to.recurring.decimal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 8/9/2017.
 */
public class Solution {

    public static void main(String[] args) {

        System.out.println(1.0/90);



        System.out.println(1.0 / 9);
        System.out.println(new BigDecimal("1").divide(new BigDecimal("333"), 20, RoundingMode.HALF_UP));
    }

    public String fractionToDecimal(int numerator, int denominator) {

        if(denominator == 0) return "0";


        int res = numerator % denominator;
        int value = numerator / denominator;

        StringBuilder frac = new StringBuilder();

        //  residual, last
        Map<Integer, Integer> cache = new HashMap<>();

        String fraction = "";
        int reslen = 0;

        while(res != 0){
            res *= 10;
            int tmp = Math.abs(res / denominator);
            frac.append(tmp);
            if(tmp > 0){
                if(cache.containsKey(res)){
                    // repeat
                    int lastIndex = cache.get(res);
                    int repeatLength = frac.length() - lastIndex - 1;
                    int startIndex = frac.length() - 1 - reslen - repeatLength;
                    if(startIndex > 0){
                        fraction = frac.substring(0, startIndex) + "(" + frac.substring(startIndex, startIndex + repeatLength) + ")";
                    } else {
                        fraction = "(" + frac.substring(0, frac.length() - reslen - 1) + ")";
                    }
                    return value + "." + fraction;
                } else {
                    cache.put(res, frac.length() - 1);
                }
                reslen = 0;
            } else {
                reslen ++;
            }

            res = res % denominator;
        }
        if(frac.length() > 0){
            return value + "." + frac.toString();
        } else {
            return String.valueOf(value);
        }

    }
}
