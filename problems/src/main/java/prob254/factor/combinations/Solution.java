package prob254.factor.combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanya04 on 1/22/2018.
 */
public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(new ArrayList<Integer>(), result, n, 2);
        return result;
    }

    private void backtrack(List<Integer> stack, List<List<Integer>> result, int n, int factor){
        if(n == 1){
            if(stack.size() > 1){
                result.add(new ArrayList<>(stack));
            }
            return;
        }
        for(int i = factor; i <= n ; i++){
            if(n % i == 0){
                stack.add(i);
                backtrack(stack, result, n / i, i);
                stack.remove(stack.size() - 1);
            }
        }
    }
}