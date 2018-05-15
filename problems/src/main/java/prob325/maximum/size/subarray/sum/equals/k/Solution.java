package prob325.maximum.size.subarray.sum.equals.k;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanya04 on 8/18/2017.
 * Modified by yanya04 on 5/14/2018.
 */
public class Solution {
    /*
        presum [0, s1, s2, ... sn]
        si - sj = k


    */
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        long[] presums = new long[n + 1];
        for(int i = 0; i < n; i ++){
            presums[i + 1] = presums[i] + nums[i];
        }
        Map<Long, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n + 1; i ++){
            map.putIfAbsent(presums[i], new ArrayList<>());
            map.get(presums[i]).add(i);
        }
        int max = 0;
        for(int i = 0; i < n + 1; i ++){
            if(map.containsKey(presums[i] + k)){
                for(Integer index: map.get(presums[i] + k)){
                    max = Math.max(max, index - i);
                }
            }
        }

        return max;

    }
}
