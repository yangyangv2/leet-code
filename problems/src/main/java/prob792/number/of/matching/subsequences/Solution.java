package prob792.number.of.matching.subsequences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int numMatchingSubseq(String S, String[] words) {

        List<Integer>[] indexes = new List[128];
        char c = 0;
        for(int i = 0; i < S.length(); i ++){
            c = S.charAt(i);
            if(indexes[c] == null){
                indexes[c] = new ArrayList<>();
            }
            indexes[c].add(i);
        }

        int count = 0, start = 0;
        for(String word: words){
            start = 0;
            boolean isSubseq = true;
            for(int i = 0; i < word.length(); i ++){
                c = word.charAt(i);
                if(indexes[c] == null) {isSubseq = false; break; } // this word has chars not in S
                int index = Collections.binarySearch(indexes[c], start);
                if(index < 0) index = - (index + 1);
                if(index == indexes[c].size()) {isSubseq = false; break; }
                start = indexes[c].get(index) + 1;
            }
            if(isSubseq) count ++;
        }
        return count;
    }
}
