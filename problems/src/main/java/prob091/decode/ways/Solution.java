package prob091.decode.ways;

/**
 * Created by yanya04 on 1/8/2018.
 * Modified by yanya04 on 5/18/2018.
 */
public class Solution {
    /*
        decode 226

        let df[i] be number of ways at char i

        dp[i] = 0< (i, i - 1) <= 9 => += dp[i - 1]
                10<= (i, i - 2) <= 26 += dp[i - 2]

    */
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        if(s.length() == 1) return s.charAt(0) == '0' ? 0: 1;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0: 1;
        int num1 = 0, num2 = 0;
        for(int i = 2; i <= n; i ++){
            num1 = Integer.parseInt(s.substring(i - 1, i));
            num2 = Integer.parseInt(s.substring(i - 2, i));
            if(num1 >= 1 && num1 <= 9) dp[i] += dp[i - 1];
            if(num2 >= 10 && num2 <= 26) dp[i] += dp[i - 2];
        }
        return dp[n];
    }
}