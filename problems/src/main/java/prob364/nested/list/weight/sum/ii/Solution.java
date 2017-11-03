package prob364.nested.list.weight.sum.ii;

import utils.list.NestedInteger;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int depthSumInverse(List<NestedInteger> nestedList) {

        return helper(nestedList, 0);
    }

    private int helper(List<NestedInteger> nestedList, int parent){

        if(nestedList == null) return 0;
        int thisSum = 0;
        int subSum = 0;

        List<NestedInteger> nextList = new ArrayList<>();
        for(NestedInteger integer: nestedList){
            if(integer.isInteger()){
                thisSum += integer.getInteger();
            } else {
                nextList.addAll(integer.getList());
            }
        }
        thisSum += parent;
        if(!nextList.isEmpty()){
            subSum = helper(nextList, thisSum);
        }

        return thisSum + subSum;
    }
}