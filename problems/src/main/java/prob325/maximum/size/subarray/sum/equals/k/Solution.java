package prob325.maximum.size.subarray.sum.equals.k;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 8/18/2017.
 */
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
/*
    idea:

    k = sum[j] - sum[i + 1]

    1 2 3 4 5 6 7 8 9

      s1    s2

*/
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0] == k ? 1 : 0;


        // <sum, index>
        Map<Integer, Integer> map = new HashMap<>();

        int maxLen = 0, sum = 0;
        for(int i = 0; i < nums.length; i ++){

            int len = 0;

            sum += nums[i];
            map.putIfAbsent(sum, i);


            if(sum == k){
                len = i + 1;
            } else {

                /*
                    iter 0: sum = 1, delta = 0, map={1: 0}
                    iter 1: sum = 2, delta = 1, map={1: 0, 2: 1}, len = 1
                    iter 2: sum = 2, delta = 1, map={1: 0, 2: 1}, len = 2
                */
                int delta = sum - k;     // delta != 0;

                if(map.containsKey(delta)){
                    len = i - map.get(delta);
                }

            }
            maxLen = Math.max(len, maxLen);
        }
        return maxLen;
    }
}
