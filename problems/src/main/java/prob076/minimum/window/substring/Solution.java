package prob076.minimum.window.substring;

import java.util.Arrays;

/**
 * Created by yanya04 on 9/2/2017.
 * Modified by yanya04 on 5/6/2018.
 */
public class Solution {
    public String minWindow(String s, String t) {

        String res = "";
        if(s == null || t == null || s.length() == 0 || t.length() == 0)
            return res;

        int[] stats = new int[128];
        int count = 0, idx = 0;
        for(int i = 0; i < t.length(); i ++){
            idx = (int) t.charAt(i);
            count ++;
            stats[idx] --;
        }

        int left = 0, right = 0, idx1 = 0, idx2 = 0, min = Integer.MAX_VALUE;

        while(right < s.length()){
            idx1 = (int)s.charAt(right ++);
            if(stats[idx1] < 0) count --;
            stats[idx1] ++;
            while(count == 0){
                idx2 = (int) s.charAt(left ++);
                stats[idx2] --;
                if(stats[idx2] < 0) count ++;
                if(min > right - left){
                    min = right - left;
                    res = s.substring(left - 1, right);
                }
            }
        }
        return res;
    }
}
