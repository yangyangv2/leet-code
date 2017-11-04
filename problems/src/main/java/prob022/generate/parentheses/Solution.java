package prob022.generate.parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();

        dfs(list, "", n, 0, 0);

        return list;
    }


    private void dfs(List<String> list, String expr, int n, int left, int right){

        if(right == n){
            // close
            list.add(expr);
            return;
        }

        if(left < n){
            dfs(list, expr + "(", n, left + 1, right);
        }

        if(right < left){
            dfs(list, expr + ")", n, left, right + 1);
        }
    }

}