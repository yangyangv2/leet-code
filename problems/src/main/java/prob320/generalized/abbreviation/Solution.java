package prob320.generalized.abbreviation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanya04 on 3/7/2018.
 */
public class Solution {

    /*  every step we move
        1) add new char as char
        2) add new char as a count
    */
    public List<String> generateAbbreviations(String word) {

        List<String> res = new ArrayList<>();
        backtrack(res, word, 0, "", 0);
        return res;
    }

    private void backtrack(List<String> res, String word, int pos, String cur, int count){
        if(pos == word.length()){
            if(count > 0){
                res.add(cur + count);
            } else {
                res.add(cur);
            }
            return;
        }
        backtrack(res, word, pos + 1, cur + ((count > 0)? count : "") + word.charAt(pos), 0);
        backtrack(res, word, pos + 1, cur, count + 1);
    }
}

