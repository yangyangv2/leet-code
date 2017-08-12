package prob454.four.sum.ii;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 7/23/2017.
 */
public class Solution {

    /* Solution1:

        1. sort 4 arrays
        2. add two arrays up and put result into cache
    */

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        if(A.length == 0) return 0;

        Map<Integer, Integer> cache = new HashMap<>();

        for(int i = 0; i < A.length; i ++){
            for(int j = 0; j < B.length; j ++){
                int result = A[i] + B[j];
                if(!cache.containsKey(result)){
                    cache.put(result, 1);
                } else {
                    cache.put(result, cache.get(result) + 1);
                }
            }
        }

        int count = 0;
        for(int i = 0; i < C.length; i ++){
            for(int j = 0; j < D.length; j ++){
                int result = -1 * (C[i] + D[j]);
                Integer match = cache.get(result);
                if(match != null){
                    count += match;
                }

            }
        }
        return count;
    }
}
