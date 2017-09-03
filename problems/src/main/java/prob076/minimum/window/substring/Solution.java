package prob076.minimum.window.substring;

import java.util.Arrays;

/**
 * Created by yanya04 on 9/2/2017.
 */
public class Solution {
    /*
        create a map counter for T
        two pointers from the begining
    */
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        Arrays.fill(map, 0);
        for(int i = 0; i < t.length(); i ++){
            map[t.charAt(i)] ++;
        }
        int i = 0, j = 0;
        int match = 0;
        int min = Integer.MAX_VALUE;
        String result = "";
/*
    S = "ADOBECODEBANC"
    T = "ABC"
    map[A] = 1, map[B] = 1, map[C] = 1
*/
        while(j < s.length()){
            if(map[s.charAt(j)]-- > 0){
                match ++;
            }
            j++;

            while(match == t.length()){
                if(min > j - i){
                    min = j - i;
                    result = s.substring(i, j);
                }

                if(map[s.charAt(i)]++ == 0){
                    match --;
                }
                i ++;
            }
        }
        return result;

    }


    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Solution solution = new Solution();
        System.out.println(solution.minWindow(s, t));
    }
}
