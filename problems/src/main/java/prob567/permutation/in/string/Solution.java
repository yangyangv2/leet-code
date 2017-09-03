package prob567.permutation.in.string;

import java.util.Arrays;

/**
 * Created by yanya04 on 8/30/2017.
 */
public class Solution {
/*
    1. count chars of s1
    2. if s2 contains a sub str s1' where s1' contains the same number of chars of s1
*/

    public boolean checkInclusion(String s1, String s2) {

        int[] count = new int[128];
        Arrays.fill(count, -1);
        int match = 0;
        for(int i = 0; i < s1.length(); i ++){
            if(count[s1.charAt(i)] == -1){
                count[s1.charAt(i)] = 0;
            }
            count[s1.charAt(i)] ++;
        }

        // {a = 1, b = 1}
        // 1. eidbaooo
        // 2. eidboaoo
        //    i
        //    j

        for(int i = 0, j = 0; j < s2.length(); j ++){

            // case 1, char s1 does not have
            // move i to j + 1, and decrease match count
            if(count[s2.charAt(j)] == -1){
                while(i <= j){
                    if(count[s2.charAt(i)] != -1){
                        count[s2.charAt(i)] ++;
                        match --;
                    }
                    i++;

                    if(count[s2.charAt(j)] > 0){
                        break;
                    }
                }
                continue;
            } else if(count[s2.charAt(j)] == 0){
                // case 2, char s1 has the char, but it's been consumed up
                // move i to the last position where s2.charAt(j) > 0;
                while(i <= j && count[s2.charAt(j)] == 0){
                    if(count[s2.charAt(i)] != -1){
                        count[s2.charAt(i)] ++;
                        match --;
                    }
                    i ++;
                }
            }

            if(count[s2.charAt(j)] > 0){
                // case 3, char s1 has the char and count[j] > 0;
                // decrease the count[j], increase match;
                count[s2.charAt(j)] --;
                match ++;
            }


            if(match == s1.length()){
                // when match == s1.length, means all matches, return
                return true;
            }

            // removet the last char and count, window slide
            if(j - i + 1 == s2.length()){
                if(count[s2.charAt(i)] != -1){
                    count[s2.charAt(i)] ++;
                    match --;
                }
                i ++;
            }
        }
        return match == s1.length();
    }
}
