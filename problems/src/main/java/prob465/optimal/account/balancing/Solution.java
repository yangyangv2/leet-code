package prob465.optimal.account.balancing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanya04 on 6/1/2018.
 * Modified by yanya04 on 6/2/2018.
 */
public class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();

        // build up balance map
        for(int[] t: transactions){
            int lender = t[0], borrower = t[1], amount = t[2];
            map.put(lender, map.getOrDefault(lender, 0) + amount);
            map.put(borrower, map.getOrDefault(borrower, 0) - amount);
        }

        // add unbalanced parties into processing list
        List<Long> list = new ArrayList<>();
        for(Integer value: map.values()){
            if(value != 0) list.add(value.longValue());
        }

        Long[] debts = new Long[list.size()];
        list.toArray(debts);

        return count(0, debts, 0);
    }

    /*
        DFS, find the minimum count to get account balanced
        start from pos=0, go up to debts.length
        compare pos with each i where i <= pos + 1, i < debts.length
    */
    public int count(int pos, Long[] debts, int count){
        // skip all zeros
        while(pos < debts.length && debts[pos] == 0) pos ++;

        if(pos == debts.length) return count;

        int res = Integer.MAX_VALUE;

        for(int i = pos + 1; i < debts.length; i ++){
            if(debts[pos] * debts[i] >= 0) continue;
            debts[i] += debts[pos];
            res = Math.min(res, count(pos + 1, debts, count + 1));
            debts[i] -= debts[pos];
        }
        return res;
    }

}