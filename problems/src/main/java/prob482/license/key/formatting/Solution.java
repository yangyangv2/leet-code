package prob482.license.key.formatting;

/**
 * Created by yanya04 on 5/25/2018.
 */
public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        S = S.replaceAll("-", "");
        S = S.toUpperCase();

        StringBuilder sb = new StringBuilder();

        int count = 0;
        for(int i = S.length() - 1; i  >= 0; i --){
            if(count ++== K){
                count = 1;
                sb.append("-");
            }
            sb.append(S.charAt(i));
        }

        return sb.reverse().toString();
    }
}
