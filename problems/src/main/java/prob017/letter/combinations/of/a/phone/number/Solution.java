package prob017.letter.combinations.of.a.phone.number;

import java.util.ArrayList;
import java.util.List;

/**
 *  Modified by yanya04 on 5/25/2018.
 */
public class Solution {

    private final static String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();

        backtrack(digits, 0, res, "", dict);

        return res;
    }

    private void backtrack(String digits, int start, List<String> list, String path, String[] dict){
        if(start == digits.length()){
            if(path.length() > 0) list.add(path);
            return;
        }

        String ops = dict[digits.charAt(start) - '0'];
        for(int i = 0; i < ops.length(); i ++){
            backtrack(digits, start + 1, list, path + ops.charAt(i), dict);
        }
    }
}