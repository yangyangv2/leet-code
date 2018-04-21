package prob153.find.minimum.in.rotated.sorted.array;

/**
 * Created by yanya04 on 8/17/2017.
 */
public class Solution {
    public int findMin(int[] nums) {

        if(nums == null || nums.length == 0) return -1;

        int lo = 0, hi = nums.length - 1, mid = 0;
        while(lo < hi) {
            mid = lo + (hi - lo) / 2;
            if(nums[mid] > nums[hi]){
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }
}
