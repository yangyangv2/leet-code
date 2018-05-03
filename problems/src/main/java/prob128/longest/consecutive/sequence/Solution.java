package prob128.longest.consecutive.sequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by yanya04 on 1/10/2018.
 * Modified by yanya04 on 5/2/2018.
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int down = 0, up = 0, max = 0;
        for(int i = 0; i < nums.length; i ++){

            if(! map.containsKey(nums[i])) continue;
            down = nums[i];
            up = nums[i];
            map.remove(nums[i]);
            while(map.containsKey(down - 1)){
                map.remove(down - 1);
                down --;
            }
            while(map.containsKey(up + 1)){
                map.remove(up + 1);
                up ++;
            }
            max = Math.max(max, up - down + 1);
        }

        return max;
    }
}