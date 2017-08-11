package prob242.valid.anagram;

import java.util.Arrays;

/**
 * Created by yanya04 on 8/10/2017.
 */
public class Solution {

    public boolean isAnagram(String s, String t) {

        int[] array = new int[256];
        Arrays.fill(array, 0);

        for(char c: s.toCharArray()){
            array[c] ++;
        }


        for(char c: t.toCharArray()){
            array[c] --;
        }

        for(int c: array){
            if(c != 0){
                return false;
            }
        }

        return true;
    }
}
