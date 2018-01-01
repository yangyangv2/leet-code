package prob415.add.strings;

public class Solution {
    public String addStrings(String num1, String num2) {

        if(num1.length() < num2.length()){
            return addStrings(num2, num1);
        }
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + 1];
        for(int i = 1; i <= m; i ++){
            res[i - 1] = num1.charAt(m - i) - '0';
        }

        int carry = 0;
        for(int i = 1; i <= n; i ++){
            int sum = res[i - 1] + ((num2.charAt(n - i)) - '0') + carry;
            carry = sum / 10;
            res[i - 1] = sum % 10;
        }

        int index = n;
        while(carry > 0){
            int sum = res[index] + carry;
            carry = sum / 10;
            res[index ++] = sum % 10;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = m; i >= 0; i --){
            if(sb.length() == 0 && res[i] == 0) continue;
            sb.append(res[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}