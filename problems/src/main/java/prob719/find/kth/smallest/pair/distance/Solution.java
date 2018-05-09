package prob719.find.kth.smallest.pair.distance;

import java.util.Arrays;

/**
 * Created by yanya04 on 5/4/2018.
 * Modified by yanya04 on 5/7/2018.
 */
public class Solution {

    // sort
    // two pointer
    // using O(n) to count the number of distances <= mid;
    public int smallestDistancePair(int[] nums, int k) {
        if(nums == null || nums.length < 2)
            return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 1; i ++){
            min = Math.min(min, nums[i + 1] - nums[i]);
        }

        int lo = min, hi = nums[nums.length - 1] - nums[0], mid = 0;
        while(lo < hi){
            mid = lo + (hi - lo) / 2;
            if(count(nums, mid) < k){
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int count(int[] nums, int mid){
        int last = 1, count = 0;
        for(int i = 0; i < nums.length - 1; i ++){
            while(last < nums.length && nums[last] - nums[i] <= mid) last ++;
            count += (last - i - 1);
        }
        return count;
    }
}