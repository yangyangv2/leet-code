package prob140.word.breaker.ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    /*
        recursive
    */

    public List<String> wordBreak(String s, List<String> wordDict) {

        Map<String, List<String>> map = new HashMap<>();

        return search(s, wordDict, map);
    }


    private List<String> search(String substr, List<String> wordDict, Map<String, List<String>> map){


        if(map.containsKey(substr)){
            return map.get(substr);
        }

        if(substr.length() == 0) {
            // no character left, add history into result
            return null;
        }


        List<String> result = new ArrayList<>();

        for(int i = 1; i <= substr.length(); i ++) {
            String word = substr.substring(0, i);
            if(wordDict.contains(word)){
                String newstr = substr.substring(i, substr.length());
                List<String> list = search(newstr, wordDict, map);
                if(list == null){
                    result.add(word);
                } else {
                    for(String str: list){
                        result.add(word + " " + str);
                    }
                }
            }
        }

        map.put(substr, result);

        return result;
    }
}