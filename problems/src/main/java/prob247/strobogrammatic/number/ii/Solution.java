package prob247.strobogrammatic.number.ii;

import java.util.*;

/**
 * Created by yanya04 on 1/21/2018.
 */
public class Solution {

    public List<String> findStrobogrammatic(int n) {
        return backtrack(n, n);
    }


    private List<String> backtrack(int left, int right){

        if(left == 0) return new ArrayList<String>(Arrays.asList(""));
        if(left == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));

        List<String> list = backtrack(left - 2, right);

        List<String> res = new ArrayList<>();
        for(String str : list){
            if(left != right)
                res.add("0" + str + "0");
            res.add("1" + str + "1");
            res.add("8" + str + "8");
            res.add("6" + str + "9");
            res.add("9" + str + "6");
        }
        return res;

    }
}
