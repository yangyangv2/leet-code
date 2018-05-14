package prob001.two.sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 7/22/2017.
 * Modified by yanya04 on 4/30/2018.
 * Modified by yanya04 on 5/14/2018.
 */

public class Solution {
    public int[] twoSum(int[] nums, int target) {

        if(nums == null || nums.length == 0) return new int[]{-1, -1};

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            if(map.containsKey(target - nums[i])){
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}