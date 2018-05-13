package prob034.search.fora.range;

/**
 * Created by yanya04 on 8/13/2017.
 * Modified by yanya04 on 5/12/2018.
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = leftMost(nums, target);
        int right = rightMost(nums, target);
        return new int[]{left, right};
    }

    private int leftMost(int[] nums, int target){
        int lo = 0, hi = nums.length - 1, mid = 0;
        while(lo <= hi){
            mid = lo + ((hi - lo) >> 1);
            if(nums[mid] == target && (mid == 0 || nums[mid - 1] != target)){
                return mid;
            } else if(nums[mid] < target){
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
            mid = lo + ((hi - lo) >> 1);
            if(nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] != target)){
                return mid;
            } else if(nums[mid] > target){
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}