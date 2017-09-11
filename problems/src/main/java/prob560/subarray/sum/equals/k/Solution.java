package prob560.subarray.sum.equals.k;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 9/10/2017.
 */
public class Solution {

/*
    (j >= i)
    sum[i, j] = sum[0, j] - sum[0, i - 1] = k;

    => a + b = k
    =>

    num:    [1, 1, 1]
    sum:    [1, 2, 3]
    k:      2

    sum(i, j) = s2 - s1 = k; ---> s2 - k = s1

*/

    public int subarraySum(int[] nums, int k) {
        // brute force
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for(int i = 1; i < nums.length; i ++){
            sums[i] = sums[i - 1] + nums[i];
        }


        // use map to optimize it

        // sum[i, j] = k = sum[j] - sum[i - 1];
        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);  // when target is 0, then sums[j] = k is an valid solution
        for(int i = 0; i < sums.length; i ++){
            int target = sums[i] - k;
            if(map.containsKey(target)){
                count += map.get(target);
            }
            map.put(sums[i], map.getOrDefault(sums[i], 0) + 1);
        }
        return count;
    }
}
