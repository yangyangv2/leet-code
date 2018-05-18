package prob254.factor.combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanya04 on 1/22/2018.
 * Modified by yanya04 on 5/15/2018.
 */
public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, 2, new ArrayList<Integer>(), res);
        return res;
    }

    private void backtrack(int n , int start, List<Integer> list, List<List<Integer>> res){
        if(n == 1){
            if(list.size() > 1){
                res.add(new ArrayList(list));
            }
            return;
        }

        for(int i = start; i <= n; i ++){
            if(n % i == 0 ) {
                list.add(i);
                backtrack(n / i, i, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
}