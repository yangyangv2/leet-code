package prob205.isomorphic.strings;

import java.util.Arrays;

/**
 * Created by yanya04 on 8/9/2017.
 * Modified by yanya04 on 5/9/2018.
 * Modified by yanya04 on 5/15/2018.
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        return compare(s, t) && compare(t, s);
    }

    private boolean compare(String s, String t){
        char[] dict = new char[128];
        for(int i = 0; i < s.length(); i ++){
            if(dict[(int)t.charAt(i)] == 0)
                dict[(int)t.charAt(i)] = s.charAt(i);
            else if(dict[(int)t.charAt(i)] != s.charAt(i))
                return false;
        }
        return true;
    }
}