package prob213.house.robber.ii;

import java.util.Arrays;

public class Solution {
    public int rob(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        if(nums.length == 1) return nums[0];

        int[] nums1 = new int[nums.length - 1];
        int[] nums2 = new int[nums.length - 1];

        int[] values1 = new int[nums.length - 1];
        int[] values2 = new int[nums.length - 1];

        Arrays.fill(values1, -1);
        Arrays.fill(values2, -1);

        for(int i = 0; i < nums.length - 1; i ++){
            nums1[i] = nums[i];
            nums2[i] = nums[i + 1];
        }
        return Math.max(rob(0, nums1, values1), rob(0, nums2, values2));
    }


    //  1 -> 2 -> 3 -> 1
    //
    //  if 1 is robbed       ---> 1, 2  (take off 3)
    //  if 1 is not robbed   ---> 2, 3  (take off 1)


    private int rob(int loc, int[] nums, int[] values){

        if(loc >= nums.length) return 0;
        if(values[loc] != -1) return values[loc];
        int result = Math.max(nums[loc] + rob(loc + 2, nums, values), rob(loc + 1, nums, values));
        values[loc] = result;
        return result;
    }
}