package prob128.longest.consecutive.sequence;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yanya04 on 1/10/2018.
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i < nums.length; i ++)
            set.add(nums[i]);

        int max = 0;
        for(int i = 0;i < nums.length; i ++){

            int down = nums[i] - 1;
            while(set.contains(down)){
                set.remove(down);
                down --;
            }
            int up = nums[i] + 1;
            while(set.contains(up)){
                set.remove(up);
                up ++;
            }

            max = Math.max(up - down - 1, max);
        }

        return max;
    }
}