package prob282.expression.add.operators;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanya04 on 2/3/2018.
 * Modified by yanya04 on 6/2/2018.
 */
public class Solution {
    /*
        char by char dfs
    */
    public List<String> addOperators(String num, int target) {

        List<String> res = new ArrayList<>();

        dfs(res, num, 0, target, "", 0, 0);

        return res;
    }

    private void dfs(List<String> res, String num, int start, int target, String path, long value, long pre){

        if(start == num.length()){
            if(value == target) res.add(path);
            return;
        }

        for(int i = start; i < num.length(); i ++){
            String cur = num.substring(start, i + 1);
            if(cur.length() > 1 && cur.charAt(0) == '0') return;
            long n = -1;
            if((n = Long.parseLong(cur))> Integer.MAX_VALUE) return;

            // handle +, -, *

            if(start == 0){
                dfs(res, num, i + 1, target, path + n, n, n);
            } else {
                dfs(res, num, i + 1, target, path + "+" + n, value + n, n);
                dfs(res, num, i + 1, target, path + "-" + n, value - n, -n);
                dfs(res, num, i + 1, target, path + "*" + n, value - pre + pre * n, pre * n);
            }

        }
        return;
    }
}
