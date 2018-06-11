package prob065.valid.number;

/*
    Modified by yanya04 on 6/10/2018.
 */
public class Solution {
    /*
        "0" => true
        " 0.1 " => true
        "abc" => false
        "1 a" => false
        "2e10" => true


        1. must contains number
        2. if there is a sign, it must be the first character or right after 'e'
        3. may have only one e
        4. may have only one . (dot) and dot must happens before e

    */
    public boolean isNumber(String s) {
        if(s == null) return false;
        s = s.trim();
        s = s.toLowerCase();

        boolean num = false;    // must has number
        boolean e = false;
        boolean dot = false;
        boolean en = true;     // if has e, then en must be true


        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = true;
                if(e) en = true;
            } else if(c == 'e'){
                if(!num || e) return false;
                e = true;
                en = false;
            } else if(c == '-' || c == '+'){
                if(i != 0 && s.charAt(i - 1) != 'e')
                    return false;
            } else if(c == '.'){
                if(dot || e ) return false;
                dot = true;
            } else {
                return false;
            }
        }

        return num && en;
    }
}