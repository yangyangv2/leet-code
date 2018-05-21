package prob043.multiply.strings;

/**
 *  Modified by yanya04 5/20/2018.
 */
public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] product = new int[m + n];

        for(int i = m - 1; i >= 0; i --){
            for(int j = n - 1; j >= 0; j --){
                int val = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                val += product[i + j + 1];
                product[i + j] += val / 10;
                product[i + j + 1] = val % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < product.length; i ++){
            if(product[i] == 0 && sb.length() == 0)
                continue;
            sb.append(String.valueOf(product[i]));
        }

        return sb.length() == 0 ? "0": sb.toString();
    }
}