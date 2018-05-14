package prob364.nested.list.weight.sum.ii;

import utils.list.NestedInteger;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if(nestedList == null) return 0;
        int res = 0;
        List<NestedInteger> nextList = new ArrayList<>();
        for(NestedInteger ni: nestedList){
            if(ni.isInteger()){
                res += ni.getInteger();
            } else {
                nextList.addAll(ni.getList());
            }
        }

        if(!nextList.isEmpty()){
            nextList.add(new NestedInteger(res));
            res += depthSumInverse(nextList);
        }
        return res;
    }
}