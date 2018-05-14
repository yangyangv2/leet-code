package prob819.most.common.word;

import java.util.*;

/**
 *  Created by yanya04 on 5/13/2018.
 */
public class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String res = null;
        if(paragraph == null) return res;


        String data = paragraph.toLowerCase();
        data = data.replaceAll("[!\\?',;\\.]", "");
        String[] words = data.split(" +");
        Set<String> set = new HashSet<>(Arrays.asList(banned == null ? new String[0]: banned));
        Map<String, Integer> map = new HashMap<>();

        int max = 0, count = 0;
        for(String word: words){
            if(set.contains(word)) continue;
            count = map.getOrDefault(word, 0) + 1;
            if(count > max){
                max = count;
                res = word;
            }
            map.put(word, count);
        }
        return res;
    }
}