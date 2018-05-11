package prob494.target.sum;

import java.util.HashMap;
import java.util.Map;

/**
 *  Created by yanya04 on 5/9/2018.
 */
public class Solution {

    public int findTargetSumWays(int[] nums, int S) {

        if(nums == null) return -1;
        if(nums.length == 0) return S == 0 ? 1: 0;
        Map<String, Integer> mem = new HashMap<>();
        return find(nums, 0, 0, S, mem);
    }

    int find(int[] nums, int start, int value, int S, Map<String, Integer> mem){

        if(start == nums.length){
            return value == S ? 1 : 0;
        }

        String key = start + "/" + value;
        if(mem.containsKey(key)) return mem.get(key);

        int res = 0;
        value += nums[start];
        res += find(nums, start + 1, value, S, mem);
        value -= nums[start] * 2;
        res += find(nums, start + 1, value, S, mem);

        mem.put(key, res);
        return res;
    }
}