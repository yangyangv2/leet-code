package prob392.is.subsequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yanya04 on 8/26/2017.
 * Modified by yanya04 on 5/22/2018.
 */
public class Solution {
    /*
        s = "abc"
        t = "ahbgdc"

        a = {0}
        h = {1}
        b = {2}
        g = {3}
        d = {4}
        c = {5}

    */
    public boolean isSubsequence(String s, String t) {

        List<Integer>[] dict = new List[128];
        char c = 0;
        for(int i = 0; i < t.length(); i ++){
            c = t.charAt(i);
            if(dict[c] == null){
                dict[c] = new ArrayList<>();
            }
            dict[c].add(i);
        }

        int start = 0, index = 0;

        for(int i = 0; i < s.length(); i ++){
            c = s.charAt(i);
            // char c does not exist in t
            if(dict[c] == null) return false;
            index = Collections.binarySearch(dict[c], start);
            if(index < 0) index = -(index + 1);
            // search miss, cannot find char after position start
            if(index == dict[c].size()) return false;
            start = dict[c].get(index) + 1;
        }
        return true;
    }
}
