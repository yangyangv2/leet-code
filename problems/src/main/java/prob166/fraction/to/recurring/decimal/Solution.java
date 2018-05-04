package prob166.fraction.to.recurring.decimal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 8/9/2017.
 * Modified by yanya04 on 4/28/2018
 */
public class Solution {

    public String fractionToDecimal(int numerator, int denominator) {

        if(numerator == 0) return "0";
        if(denominator == 0) {
            if(numerator > 0) return "inf";
            else return "-inf";
        }


        long numer = (long) numerator;
        long denom = (long) denominator;

        StringBuilder sb = new StringBuilder();
        if(numer > 0 ^ denom > 0) {
            // negative result
            sb.append("-");
        }

        numer = Math.abs(numer);
        denom = Math.abs(denom);

        long integral = numer / denom;
        long remain = numer % denom;

        // add the integral part
        sb.append(String.valueOf(integral));

        if(remain == 0) return sb.toString();

        // prepar for the fractional
        sb.append(".");
        Map<Long, Integer> indexMap = new HashMap<>();
        while(remain != 0) {
            if(indexMap.containsKey(remain)){
                sb.insert(indexMap.get(remain), "(");
                sb.append(")");
                break;
            }
            indexMap.put(remain, sb.length());
            remain *= 10;
            integral = remain / denom;
            remain = remain % denom;
            sb.append(String.valueOf(integral));
        }

        return sb.toString();
    }
}