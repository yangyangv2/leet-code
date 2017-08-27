package prob392.is.subsequence;

/**
 * Created by yanya04 on 8/26/2017.
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {

        int index = -1;
        for(char c: s.toCharArray()){
            index = t.indexOf(c, index + 1);
            if(index < 0){
                return false;
            }
        }

        return true;
    }
}
