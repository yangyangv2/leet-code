package prob118.pascals.triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // row[0] = 1
    // row[1] = 1,1
    // row[2] = 1,2,1
    // row[3] = 1,3,3,1     x[i,j] = x[i-1, j-1] + x[i-1,j]
    // row[4] = 1,4,6,4,1

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0) return result;

        for(int i = 0; i < numRows; i ++){
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            if(!result.isEmpty()){
                List<Integer> pre = result.get(result.size() - 1);
                for(int j = 1; j < i; j ++){
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
                cur.add(pre.get(i - 1));
            }
            result.add(cur);
        }
        return result;
    }
}