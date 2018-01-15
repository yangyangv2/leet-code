package prob171.excel.sheet.column.number;

/**
 * Created by yanya04 on 1/15/2018.
 */
public class Solution {

/*
    AA

     1
    +26 = 27
*/


    public int titleToNumber(String s) {

        int len = s.length();

        int res = 0;
        int base = 0;
        for(int i = len - 1; i >= 0; i --){
            int num = 1 + s.charAt(i) - 'A';
            res += num * Math.pow(26, base ++);
        }

        return res;
    }
}