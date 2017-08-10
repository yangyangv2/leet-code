package prob205.isomorphic.strings;

import java.util.Arrays;

/**
 * Created by yanya04 on 8/9/2017.
 */
public class Solution
{
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        return isIsomorphicMono(s, t) && isIsomorphicMono(t, s);
    }

    private boolean isIsomorphicMono(String s, String t){
        char[] charmap = new char[128];
        Arrays.fill(charmap, (char)0);
        for(int i = 0; i < s.length(); i ++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            char mc = charmap[sc];
            if(mc == 0){
                charmap[sc] = tc;
            } else if(tc != mc){
                return false;
            }
        }
        return true;
    }
}
