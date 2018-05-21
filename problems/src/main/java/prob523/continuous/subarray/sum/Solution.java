package prob523.continuous.subarray.sum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 9/10/2017.
 * Modified by yanya04 on 5/20/2018.
 */
public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        if(nums == null || nums.length == 0) return false;
        int n = nums.length;
        for(int i = 0; i < n - 1; i ++){
            if(nums[i] == 0 && nums[i + 1] == 0)
                return true;
        }

        if(k == 0) return false;

        Map<Integer, Integer> map = new HashMap<>();

        // when sum == k, sum % k == 0, then the other index is - 1;
        map.put(0, - 1);

        // s[j] - s[i] = k * n
        // (s[j] - s[i]) % k == 0
        // s[j] % k == s[i] % k

        int presum = 0;
        for(int i = 0; i < nums.length; i ++) {
            presum += nums[i];
            int value = presum % k;
            Integer index = map.get(value);
            if(index != null){
                if(i - index > 1)
                    return true;
            } else {
                map.put(value, i);
            }
        }

        return false;
    }
}