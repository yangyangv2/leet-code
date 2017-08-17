package prob153.find.minimum.in.rotated.sorted.array;

/**
 * Created by yanya04 on 8/17/2017.
 */
public class Solution {
    public int findMin(int[] nums) {

        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];

        return nums[findPivot(nums)];
    }

    private int findPivot(int[] nums){
        int lo = 0, hi = nums.length - 1;
        while(lo < hi){
            if(nums[lo] < nums[hi]){
                break;
            } else if(nums[lo] == nums[hi]){
                lo ++;
            } else {
                // since no duplicates allows, therefore
                // case 1  3 4 5 6 7 1 2
                // case 2  6 7 1 2 3 4 5
                int mid = lo + (hi - lo) / 2;
                if(nums[lo] <= nums[mid]){
                    lo = mid + 1;
                } else { // nums[lo] > nums[mid]
                    hi = mid;
                }
            }
        }
        return lo;
    }
}
