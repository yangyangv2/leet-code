package prob459.repeated.substring.pattern;

/**
 * Created by yanya04 on 3/19/2018.
 */
public class Solution {

    /*
        len(s) = n;
        try every i is divisor of n;
    */
    public boolean repeatedSubstringPattern(String s) {

        int n = s.length();

        if(n == 1) return false;

        for(int i = 1; i <= n / 2; i ++){
            if(n % i == 0){
                String substr = s.substring(0, i);
                int m = substr.length();
                boolean repeat = true;
                for(int j = i; j < n; j += m){
                    if(!substr.equals(s.substring(j, j + m))){
                        repeat = false;
                        break;
                    }
                }
                if(repeat){
                    return true;
                }
            }
        }
        return false;
    }
}
