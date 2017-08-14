package prob034.search.fora.range;

/**
 * Created by yanya04 on 8/13/2017.
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {

        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        int start = findLeftMost(nums, 0, nums.length - 1, target);
        if(start >= nums.length || nums[start] != target){
            // doesn not find or not equal
            return new int[]{-1, -1};
        } else {
            int end = findLeftMost(nums, start, nums.length, target + 1);
            return new int[]{start, end - 1};
        }

    }

    private int findLeftMost(int[] nums, int start, int end, int target){

        if(start >= end){
            return start;
        }

        int mid = start + (end - start) / 2;

        if(nums[mid] < target){
            return findLeftMost(nums, mid + 1, end, target);
        } else {
            return findLeftMost(nums, start, mid, target);
        }
    }
}
