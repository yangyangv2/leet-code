package prob035.serach.insert.position;

import java.util.Arrays;

/**
 * Created by yanya04 on 8/13/2017.
 */
public class Solution {

    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid = 0;
        while(lo <= hi){
            mid = lo + (hi - lo) / 2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    public int searchLeftInsert(int[] nums, int target){
        int lo = 0, hi = nums.length - 1, mid = 0;
        while(lo <= hi){
            mid = lo + (hi - lo) / 2;
            if(target <= nums[mid]){
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        if(lo == nums.length || nums[lo] != target){
            return - (lo + 1);
        } else {
            return lo;
        }
    }

    public int searchRightInsert(int[] nums, int target){
        int lo = 0, hi = nums.length - 1, mid = 0;
        while(lo <= hi){
            mid = lo + (hi - lo) / 2;
            if(target >= nums[mid]){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        if(hi == -1 || nums[hi] == target){
            return hi;
        } else {
            return -(hi + 2);
        }
    }



    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,3};
        Solution solution = new Solution();
        int target = 0;
        System.out.println(solution.searchLeftInsert(nums,target));
        System.out.println(solution.searchRightInsert(nums,target));
    }
}
