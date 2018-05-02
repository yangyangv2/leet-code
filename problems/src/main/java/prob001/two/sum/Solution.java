package prob001.two.sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 7/22/2017.
 * Modified by yanya04 on 4/30/2018.
 */

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer index = null;
        for(int i = 0; i < nums.length; i ++){
            index = map.get(target - nums[i]);
            if(index != null){
                return new int[]{index, i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
