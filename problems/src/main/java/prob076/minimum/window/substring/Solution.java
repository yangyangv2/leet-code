package prob076.minimum.window.substring;

import java.util.Arrays;

/**
 * Created by yanya04 on 9/2/2017.
 * Modified by yanya04 on 5/6/2018.
 * Modified by yanya04 on 5/18/2018.
 */
public class Solution {
    public String minWindow(String s, String t) {
        int[] stats = new int[128];
        for(int i = 0; i < t.length(); i ++){
            stats[(int)t.charAt(i)] ++;
        }
        int start = 0, end = 0, min = s.length(), count = t.length();
        String res = "";

        while(end < s.length()){
            if(stats[(int) s.charAt(end ++)] -- > 0) count --;
            while(count == 0){

                if(end - start <= min){
                    min = end - start;
                    res = s.substring(start, end);
                }
                if(stats[(int) s.charAt(start ++)] ++ == 0) count ++;
            }

        }
        return res;
    }
}
