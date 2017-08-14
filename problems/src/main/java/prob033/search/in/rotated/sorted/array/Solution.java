package prob033.search.in.rotated.sorted.array;

/**
 * Created by yanya04 on 8/13/2017.
 */
public class Solution {

/*
    solution:

    find offset
    use binary search with offset

*/

    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) return -1;

        int lo = 0, hi = nums.length - 1;

        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] > nums[hi]){
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        int rotate = lo;

        // it's much easier to add rotate offset here
        lo = 0 + rotate;
        hi = nums.length - 1 + rotate;

        while(lo <= hi){
            int mid = lo + (hi - lo) /2;
            int midValue = nums[mid % nums.length];
            if( midValue == target) return mid % nums.length;
            else if(midValue < target){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;

    }
}
