package prob763.partition.labels;

import java.util.ArrayList;
import java.util.List;

/**
 *  Created by yanya04 5/22/2018.
 *  Modified by yanya04 6/1/2018.
 */
public class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] lastIndex = new int[26];
        for(int i = 0; i < S.length(); i ++){
            lastIndex[S.charAt(i) - 'a'] = i;
        }

        List<Integer> list = new ArrayList<>();
        int furthest = 0, count = 0;
        for(int i = 0; i < S.length(); i ++){
            furthest = Math.max(furthest, lastIndex[S.charAt(i) - 'a']);
            count ++;
            if(i == furthest || i == S.length() - 1){
                list.add(count);
                count = 0;
            }
        }
        return list;
    }
}