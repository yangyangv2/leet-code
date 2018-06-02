package prob392.is.subsequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yanya04 on 8/26/2017.
 * Modified by yanya04 on 5/22/2018.
 * Modified by yanya04 on 6/1/2018.
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for(int i = 0; i < s.length(); i ++){
            index = t.indexOf(s.charAt(i), index + 1);
            if(index < 0)
                return false;
        }
        return true;
    }
}