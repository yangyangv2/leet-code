package prob282.expression.add.operators;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanya04 on 2/3/2018.
 */
public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if(num == null || num.length() == 0) return res;
        backtrack(0, num, "", res, 0, 0, target);
        return res;
    }

    private void backtrack(int start, String num, String path, List<String> res, long value, long pre, int target){
        if(start == num.length()){
            if(target == value){
                res.add(path);
            }
            return;
        }

        for(int i = start; i < num.length(); i ++){
            String cur = num.substring(start, i + 1);
            if(cur.charAt(0) == '0' && cur.length() > 1)
                continue;
            if(Long.parseLong(cur) > Integer.MAX_VALUE)
                continue;

            long n = Long.parseLong(cur);
            if(start == 0){
                backtrack(i + 1, num, cur, res, n, Long.parseLong(cur), target);
            } else {
                backtrack(i + 1, num, path + "+" + cur, res, value + n, n, target);
                backtrack(i + 1, num, path + "-" + cur, res, value - n, -n, target);
                backtrack(i + 1, num, path + "*" + cur, res, value - pre + pre * n, pre * n, target);
            }
        }

    }
}
