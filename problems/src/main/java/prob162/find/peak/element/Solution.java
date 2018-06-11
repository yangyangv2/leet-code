package prob162.find.peak.element;

/**
 * Created by yanya04 on 8/18/2017.
 * Modified by yanya04 on 5/19/2018.
 * Modified by yanya04 on 6/10/2018.
 *
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null) return -1;
        int n = nums.length;
        if(0 == n) return -1;
        if(1 == n) return 0;
        if(2 == n) return nums[0] > nums[1] ? 0: 1;

        int lo = 0, hi = n - 1;
        while(lo + 2 <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]){
                return mid;
            } else if(nums[mid - 1] > nums[mid]){
                hi = mid;
            } else {
                lo = mid;
            }
        }

        return nums[lo] > nums[hi] ? lo : hi;

    }
}
