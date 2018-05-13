package prob081.search.in.rotated.sorted.array.ii;

/**
 * Created by yanya04 on 8/17/2017.
 * Modified by yanya04 on 5/12/2018.
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        int pivot = findPivot(nums);

        int lo = 0, hi = nums.length - 1, mid = 0, n = nums.length;
        while(lo <= hi){
            mid = lo + (hi - lo) / 2;
            if(nums[ (mid + pivot) % n ] == target){
                return true;
            } else if(nums[ (mid + pivot) % n ] < target){
                lo = lo + 1;
            } else {
                hi = hi - 1;
            }
        }

        return false;
    }

    private int findPivot(int[] nums){
        int lo = 0, hi = nums.length - 1, mid = 0;

        while(lo < hi){
            mid = lo + (hi - lo) / 2;
            if(nums[mid] > nums[hi]){
                lo = mid + 1;
            } else if(nums[mid] < nums[hi]){
                hi = mid;
            } else {
                hi = hi - 1;
            }
        }

        return lo;
    }
}
