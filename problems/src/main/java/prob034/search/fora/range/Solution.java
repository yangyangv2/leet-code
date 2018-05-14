package prob034.search.fora.range;

/**
 * Created by yanya04 on 8/13/2017.
 * Modified by yanya04 on 5/12/2018.
 * Modified by yanya04 on 5/14/2018.
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1, -1};
        return new int[]{leftMost(nums, target), rightMost(nums, target)};
    }

    private int leftMost(int[] nums, int target){
        int lo = 0, hi = nums.length - 1, mid = 0;
        while(lo <= hi){
            mid = lo + (hi - lo) / 2;
            if(nums[mid] == target && (mid == 0 || nums[mid - 1] != target)){
                return mid;
            } else if(target > nums[mid]){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }


    private int rightMost(int[] nums, int target){
        int lo = 0, hi = nums.length - 1, mid = 0;
        while(lo <= hi){
            mid = lo + (hi - lo) / 2;
            if(nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] != target)){
                return mid;
            } else if(target < nums[mid]){
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}