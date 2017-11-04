package prob017.letter.combinations.of.a.phone.number;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private final static String[] CODE_MAP = new String[]{
            "",     //  0
            "",     //  1
            "abc",  //  2
            "def",  //  3
            "ghi",
            "jkl",  //  5
            "mno",
            "pqrs", //  7
            "tuv",  //  8
            "wxyz"  //  9
    };

    public List<String> letterCombinations(String digits) {

        // get a list of lists and find all combinations

        List<String> result = new ArrayList<>();
        List<char[]> combs = new ArrayList<>();
        for(Character c: digits.toCharArray()){
            char[] chars = CODE_MAP[c - '0'].toCharArray();
            if(chars != null && chars.length > 0)
                combs.add(chars);
        }

        dfs(combs, result, new StringBuilder());

        return result;

    }

    private void dfs(List<char[]> combs, List<String> result, StringBuilder path){

        int depth = path.length();

        if(depth == combs.size()){
            if(path.length() > 0){
                result.add(path.toString());
            }
            return;
        }

        char[] chars = combs.get(depth);
        for(char c: chars){
            path.append(c);
            dfs(combs, result, path);
            path.deleteCharAt(depth);
        }
    }
}