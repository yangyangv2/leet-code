package prob081.search.in.rotated.sorted.array.ii;

/**
 * Created by yanya04 on 8/17/2017.
 */
public class Solution {
    public boolean search(int[] nums, int target) {

        if(nums == null || nums.length == 0){
            return false;
        }
        if(nums.length == 1){
            return nums[0] == target;
        }
        int offset = findOffset(nums);
        int lo = 0 + offset, hi = nums.length + offset - 1;
        int n = nums.length;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid % n] == target){
                return true;
            } else if(nums[mid % n] < target){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }

    /*
        find rotate array offset


        1 2 3 4 5 6 7

        6 7 1 2 3 4 5   return 2
        4 5 6 7 1 2 3   return 4
        1 1 1 1 2 1 1   return 5
        1 1 1 1 0 1 1   return 4
        lo          hi
    */

    private int findOffset(int[] nums){
        int lo = 0, hi = nums.length - 1;
        while(lo < hi){
            if(nums[lo] < nums[hi]){
                break;
            } else if(nums[lo] == nums[hi]){
                lo ++;
            } else { // nums[lo] > nums[hi]
                int mid = lo + (hi - lo) / 2;    // when lo = hi - 1, mid = lo
                if(nums[lo] <= nums[mid]){
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
        }
        return lo;
    }
}
