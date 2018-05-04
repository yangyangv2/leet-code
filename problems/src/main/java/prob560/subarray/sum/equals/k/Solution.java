package prob560.subarray.sum.equals.k;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 9/10/2017.
 * Modified by yanya04 on 5/2/2018.
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int sum = 0;

        // find sums[i]  = k + sums[j] (i > j);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int res = 0;
        for(int i = 0; i < n; i ++){
            sum = sum + nums[i];
            if(map.containsKey(sum - k)){
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
