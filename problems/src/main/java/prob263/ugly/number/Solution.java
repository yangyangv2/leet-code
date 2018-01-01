package prob263.ugly.number;

public class Solution {
    public boolean isUgly(int num) {

        if ( num == 1) return true;
        int org = num;

        while(num > 0 && num % 2 == 0) num /= 2;
        while(num > 0 && num % 3 == 0) num /= 3;
        while(num > 0 && num % 5 == 0) num /= 5;

        // does not contain either 2, 3, 5;
        if(org == num) return false;

        return num == 1;
    }
}