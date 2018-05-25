package prob763.partition.labels;

import java.util.ArrayList;
import java.util.List;

/**
 *  Created by yanya04 5/22/2018.
 */
public class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] lastIndex = new int[128];
        char c = 0;
        for(int i = 0; i < S.length(); i ++){
            c = S.charAt(i);
            lastIndex[c] = i;
        }

        List<Integer> res = new ArrayList<>();
        int count = 0, last = 0;
        for(int i = 0; i < S.length(); i ++){
            c = S.charAt(i);
            last = Math.max(lastIndex[c], last);
            count ++;
            if(last == i || i == S.length() - 1){
                res.add(count);
                count = 0;
            }
        }
        return res;
    }
}