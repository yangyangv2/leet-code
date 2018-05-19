package prob162.find.peak.element;

/**
 * Created by yanya04 on 8/18/2017.
 * Modified by yanya04 on 5/19/2018.
 *
 */
public class Solution {
    public int findPeakElement(int[] nums) {

        int lo = 0, hi = nums.length - 1, mid = 0;
        while(lo < hi){
            mid = lo + (hi - lo) / 2;
            if(nums[mid] < nums[mid + 1]){
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}

