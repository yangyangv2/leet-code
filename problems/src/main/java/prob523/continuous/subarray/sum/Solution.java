package prob523.continuous.subarray.sum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 9/10/2017.
 * Modified by yanya04 on 5/20/2018.
 * Modified by yanya04 on 6/12/2018.
 */
public class Solution {

    /*
        S[i] - S[j] = k * n     i - j > 0, n = 0,1,2,3,4,5...
        (S[i] - S[j]) % k = 0 ===> S[i] % k - S[j] % k = 0;

        (14 - 5) % 3 = 0 ===> 14 % 3 - 5 % 3

    */
    public boolean checkSubarraySum(int[] nums, int k) {

        if(nums == null || nums.length == 0) return false;
        int n = nums.length;
        for(int i = 0; i < n - 1; i ++){
            if(nums[i] == 0 && nums[i + 1] == 0)
                return true;
        }

        if(k == 0) return false;

        int presum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int i = 0; i < n; i ++){
            presum += nums[i];
            int key = presum % k;
            Integer index = map.get(key);
            if(index == null){
                map.put(key, i);
            } else {
                if(i - index > 1) return true;
            }
        }
        return false;

    }
}