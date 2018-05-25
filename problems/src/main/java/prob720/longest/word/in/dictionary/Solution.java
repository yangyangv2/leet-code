package prob720.longest.word.in.dictionary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    Created by yanya04 on 5/24/2018.
 */
public class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> visited = new HashSet<>();
        String res = "";
        for(String word: words){
            if(word.length() == 1 || visited.contains(word.substring(0, word.length() - 1))){
                visited.add(word);
                res = word.length() > res.length() ? word : res;
            }
        }
        return res;
    }
}