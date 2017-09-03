package prob524.longest.word.in.dictionary.through.deleing;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yanya04 on 8/28/2017.
 */
public class Solution {
    public String findLongestWord(String s, List<String> d) {

        // sorted, length from large to small, words in alphabetic order
        Collections.sort(d, new Comparator<String>(){
            public int compare(String o1, String o2){
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                } else {
                    return o2.length() - o1.length();
                }
            }
        });

        // for each str, find if it can be fit in the input s

        for(String w: d){
            int startIndex = -1;
            boolean match = true;
            for(int i = 0; i < w.length(); i ++){
                startIndex = s.indexOf(w.charAt(i), startIndex + 1);
                if(startIndex == -1){
                    // fail, give up this world
                    match = false;
                    break;
                }
            }
            if(match){
                return w;
            }
        }

        return "";
    }
}
