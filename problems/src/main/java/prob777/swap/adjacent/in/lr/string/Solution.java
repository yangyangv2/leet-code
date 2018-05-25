package prob777.swap.adjacent.in.lr.string;

/**
 *  Created by yanya04 5/22/2018.
 */
public class Solution {

/*
    start = "RXXLRXRXL",
    end = "XRLXXRRLX"

    s:  "RXXLRXRXL"
    e:  "XRLXXRRLX"
=>
    s:   RLRRL
    e:   RLRRL
*/

    public boolean canTransform(String start, String end) {

        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        char c = 0;
        for(int i = 0; i < start.length(); i ++ ){
            c = start.charAt(i);
            if(c != 'X') sb1.append(c);
        }

        for(int i = 0; i < end.length(); i ++){
            c = end.charAt(i);
            if(c != 'X') sb2.append(c);
        }

        // this comparison gurantees the position of L and R is safe
        // e.g, L can never go the the right or R, and vice versa
        if(!sb1.toString().equals(sb2.toString())) return false;

        if(start.length() != end.length()) return false;

        int count = 0;

        // s[L] cannot show up BEFORE e[L]
        for(int i = 0; i < start.length(); i ++) {
            if(start.charAt(i) == 'L')
                count ++;

            if(end.charAt(i) == 'L')
                count --;

            if(count > 0)
                return false;
        }

        // s[R] cannot show AFTER e[R]
        for(int i = 0; i < start.length(); i ++) {
            if(start.charAt(i) == 'R')
                count ++;

            if(end.charAt(i) == 'R')
                count --;

            if(count < 0)
                return false;
        }

        return true;
    }
}