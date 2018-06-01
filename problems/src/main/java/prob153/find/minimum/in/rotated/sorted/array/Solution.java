package prob153.find.minimum.in.rotated.sorted.array;

/**
 * Created by yanya04 on 8/17/2017.
 * Modified by yanya04 on 6/1/2018.
 */
public class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] > nums[hi]){
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }
}
