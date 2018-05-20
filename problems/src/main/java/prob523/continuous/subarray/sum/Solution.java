package prob523.continuous.subarray.sum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 9/10/2017.
 * Modified by yanya04 on 5/20/2018.
 */
public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        int presum = 0, value = 0;

        // Two continuous "0" will form a subarray which has sum = 0. 0 * k == 0 will always be true.
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i + 1] == 0) return true;
        }
        if(k == 0) return false;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for(int i = 0; i < nums.length; i ++){
            presum += nums[i];

            value = ( k != 0 ) ? presum % k : presum;

            Integer index = map.get(value);

            if(index != null){
                if(i - index > 1){
                    return true;
                }
            } else {
                map.put(value, i);
            }
        }
        return false;
    }
}