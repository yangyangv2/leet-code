package prob077.combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanya04 on 1/4/2018.
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, k, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> list, int n, int k, int start){

        if(k == 0){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = start + 1; i <= n; i ++){
            list.add(i);
            backtrack(result, list, n, k - 1, i);
            list.remove(list.size() - 1);
        }
    }
}
