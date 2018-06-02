package prob719.find.kth.smallest.pair.distance;

import java.util.Arrays;

/**
 * Created by yanya04 on 5/4/2018.
 * Modified by yanya04 on 5/7/2018.
 * Modified by yanay04 on 6/1/2018.
 */
public class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        // return bucket(nums, k);
        return binary(nums, k);
    }

    private int binary(int[] nums, int k){
        Arrays.sort(nums);
        int n = nums.length;
        int lo = 0, hi = nums[n - 1] - nums[0];
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;

            // count the number of elements smaller than mid;

            int smalls = 0, end = 1;
            for(int i = 0; i < n; i ++){
                while(end < n && nums[end] - nums[i] <= mid) end ++;
                smalls += (end - i - 1);
            }

            if(smalls < k){
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }


    /*
        space: O(1000000)
        timeL  O(n^2);
    */
    private int bucket(int[] nums, int k){
        int[] bucket = new int[1000000];
        int n = nums.length;
        for(int i = 1; i < n; i ++){
            for(int j = 0; j < i; j ++){
                bucket[Math.abs(nums[i] - nums[j])]++;
            }
        }

        for(int i = 0; i < bucket.length; i ++){
            if(bucket[i] == 0) continue;
            k -= bucket[i];
            if(k <= 0) return i;
        }
        return -1;
    }
}