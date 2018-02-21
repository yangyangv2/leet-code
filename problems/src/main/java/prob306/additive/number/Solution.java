package prob306.additive.number;

/**
 * Created by yanya04 on 2/21/2018.
 */
public class Solution {

    /*
        1. recursive
        2. first num  (i): [0, 4 / 2]
        3. second num (j): [1, max(i, j) <= n - i - j]  // offset

    */

    public boolean isAdditiveNumber(String num) {

        int n = num.length();

        // the lens of the first number is from 1 to (n - 1) / 2
        for(int i = 1; i <= n / 2; ++ i){
            // the lens of the second number is from 1 to n - i - j >= max(i , j);
            for(int j = 1; n - i - j >= Math.max(i, j); ++j){
                if(isValid(i, j, num)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isValid(int i, int j, String num){


        //int max = String.valueOf(Integer.MAX_VALUE).length();
        // if(i > max || j > max) return false;

        if(i > 1 && num.charAt(0) == '0') return false;
        if(j > 1 && num.charAt(i) == '0') return false;

        long first = Long.parseLong(num.substring(0, i));
        long second = Long.parseLong(num.substring(i, i + j));

        long sum = first + second;


        String thirdStr = num.substring(i + j);

        String sumStr = String.valueOf(sum);

        if(!thirdStr.startsWith(sumStr)){
            return false;
        } else if(thirdStr.equals(sumStr)){
            return true;
        } else {
            return isValid(j, sumStr.length(), num.substring(i));
        }

    }

}