package prob205.isomorphic.strings;

import java.util.Arrays;

/**
 * Created by yanya04 on 8/9/2017.
 * Modified by yanya04 on 5/9/2018.
 * Modified by yanya04 on 5/15/2018.
 * Modified by yanya04 on 6/1/2018.
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {

        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        int[] pos = new int[512];
        for(int i = 0; i < s.length(); i ++){
            if( pos[s.charAt(i)] != pos[t.charAt(i) + 256])
                return false;
            pos[s.charAt(i) ] = i + 1;
            pos[t.charAt(i)  + 256] = i + 1;
        }

        return true;
    }
}