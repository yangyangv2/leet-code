package prob719.find.kth.smallest.pair.distance;

import java.util.Arrays;

/**
 * Created by yanya04 On 5/4/2018.
 */
public class Solution {
    public int smallestDistancePair(int[] nums, int k) {

        Arrays.sort(nums);
        int n = nums.length;
        int lo = 0, hi = nums[n - 1] - nums[0], mid = 0, count = 0;

        while(lo < hi){
            mid = lo + (hi - lo) / 2;
            count = count(nums, mid);
            if(count >= k){
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    // count the pairs has distance smaller than mid
    private int count(int[] nums, int mid){
        int count = 0, last = 0;
        for(int i = 0; i < nums.length; i ++){
            while(last < nums.length && nums[last] - nums[i] <= mid) last ++;
            count += last - i - 1;
        }
        return count;
    }
}