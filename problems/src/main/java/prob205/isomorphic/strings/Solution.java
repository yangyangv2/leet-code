package prob205.isomorphic.strings;

import java.util.Arrays;

/**
 * Created by yanya04 on 8/9/2017.
 * Modified by yanya04 on 5/9/2018.
 */
public class Solution {
    /*
         be careful with this case:
         [a] = b
         [b] = b
    */
    public boolean isIsomorphic(String s, String t) {
        if(s == t) return true;
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;

        return compare(s, t) && compare(t, s);
    }

    private boolean compare(String s, String t){
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        char[] dict = new char[128];
        for(int i = 0; i < ch1.length; i ++){
            if(dict[(int)ch1[i]] == 0){
                dict[(int)ch1[i]] = ch2[i];
            } else if(dict[(int) ch1[i]] != ch2[i]){
                return false;
            }
        }
        return true;
    }

}