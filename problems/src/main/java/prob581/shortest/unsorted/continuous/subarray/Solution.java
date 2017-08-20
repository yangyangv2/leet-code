package prob581.shortest.unsorted.continuous.subarray;

/**
 * Created by yanya04 on 8/20/2017.
 */
class Solution {
    public int findUnsortedSubarray(int[] nums) {


        /*

        Naive Solution

        O(nlog(n)), O(n)


        int[] sorted_nums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted_nums);

        int i = 0, j = sorted_nums.length - 1;
        while(i < nums.length && nums[i] == sorted_nums[i]) i++;
        while(j > i && nums[j] == sorted_nums[j]) j --;

        */

        /*

        */

        int i = 0, j = nums.length - 1;


        while(i < j && nums[i] <= nums[i + 1]) i ++;

        if(i >= j) return 0;

        while(nums[j] >= nums[j - 1]) j --;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(int k = i; k <= j; k ++){
            min = Math.min(min, nums[k]);
            max = Math.max(max, nums[k]);
        }

        while(i >= 0 && min < nums[i]) i --;
        while(j < nums.length && nums[j] < max) j ++;


        return j - i - 1;

    }
}
