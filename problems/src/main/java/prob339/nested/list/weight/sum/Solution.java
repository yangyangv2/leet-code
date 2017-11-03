package prob339.nested.list.weight.sum;

import utils.list.NestedInteger;

import java.util.List;

public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }

    private int depthSum(List<NestedInteger> nestedList, int depth){

        if(nestedList == null) return 0;

        int sum = 0;
        for(NestedInteger integer: nestedList){
            if(integer.isInteger()){
                sum += integer.getInteger() * depth;
            } else {
                sum += depthSum(integer.getList(), depth + 1);
            }
        }
        return sum;
    }
}