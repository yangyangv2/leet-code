package prob066.plus.one;

/**
 * Created by yanya04 on 8/8/2017.
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i --){
            int sum = digits[i] + 1;
            if(sum < 10){
                digits[i] = sum;
                carry = 0;
                break;
            } else {
                digits[i] = sum % 10;
                carry = sum / 10;
            }
        }

        if(carry > 0){

            int[] digits2 = new int[digits.length + 1];
            digits2[0] = carry;

            for(int i = 0; i < digits.length; i ++){
                digits2[i + 1] = digits[i];
            }
            return digits2;
        } else {
            return digits;
        }
    }
}
