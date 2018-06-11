package prob017.letter.combinations.of.a.phone.number;

import java.util.ArrayList;
import java.util.List;

/**
 *  Modified by yanya04 on 5/25/2018.
 *  Modified by yanya04 on 6/10/2018.
 */
public class Solution {

    private final static String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        backtrack(digits, 0, "", res, dict);
        return res;
    }

    private void backtrack(String str, int start, String cur, List<String> res, String[] dict){
        if(start == str.length()){
            if(str.length() != 0) res.add(cur);
            return;
        }
        for(char c: dict[str.charAt(start) - '0'].toCharArray()){
            backtrack(str, start + 1, cur + c, res, dict);
        }
    }
}