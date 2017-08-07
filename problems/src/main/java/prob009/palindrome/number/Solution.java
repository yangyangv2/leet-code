package prob009.palindrome.number;

/**
 * Created by yanya04 on 8/6/2017.
 */
public class Solution {
    public boolean isPalindrome(int x) {

        if(x == 0){
            return true;
        } else if(x < 0 || x % 10 == 0){
            return false;
        }

        int reverse = 0;
        while(x > reverse){
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        // case:     11
        // case:     121
        // case:     1
        // case:     1221
        // case:     1000

        // x = 12
        // reserver = 12;

        return x == reverse || x == reverse / 10;

    }
}
