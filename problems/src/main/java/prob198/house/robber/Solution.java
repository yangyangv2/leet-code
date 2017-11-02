package prob198.house.robber;

import java.util.Arrays;

public class Solution {
    public int rob(int[] nums) {

        int[] map = new int[nums.length];       // space O(n)
        Arrays.fill(map, -1);
        return rob(nums, 0, map);
    }

    private int rob(int[] nums, int loc, int[] map){

        if(loc >= nums.length) return 0;
        int result = map[loc];
        if(result != -1) return result;
        result = Math.max(nums[loc] + rob(nums, loc + 2, map), rob(nums, loc + 1, map));
        map[loc] = result;
        return result;
    }
}