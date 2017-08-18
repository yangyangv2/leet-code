package prob162.find.peak.element;

/**
 * Created by yanya04 on 8/18/2017.
 */
public class Solution {
    public int findPeakElement(int[] nums) {

        if(nums == null || nums.length == 0){
            return -1;
        }
        if(nums.length == 1) return 0;


        int lo = 0, hi = nums.length - 1;

        while(lo < hi){
            int mid1 = lo + (hi - lo)/ 2;
            int mid2 = mid1 + 1;
            if(nums[mid1] < nums[mid2]){
                lo = mid2;
            } else {
                hi = mid1;
            }
        }
        return lo;  // lo == hi;

    }
}

