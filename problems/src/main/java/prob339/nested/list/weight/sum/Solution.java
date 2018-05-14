package prob339.nested.list.weight.sum;

import utils.list.NestedInteger;

import java.util.List;

/**
 *  Modified by yanya04 on 5/14/2018.
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null) return 0;
        return depthSum(nestedList, 1);
    }

    private int depthSum(List<NestedInteger> list, int depth){

        int res = 0;
        for(NestedInteger ni: list){
            if(ni.isInteger()){
                res += ni.getInteger() * depth;
            } else {
                res += depthSum(ni.getList(), depth + 1);
            }
        }
        return res;
    }
}