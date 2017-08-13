package prob035.serach.insert.position;

/**
 * Created by yanya04 on 8/13/2017.
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {

        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int start, int end, int target){

        if(start > end){
            return start;
        }

        int mid = start + (end - start) / 2;

        if(nums[mid] == target){
            return mid;
        } else if(nums[mid] > target){
            return search(nums, start, mid - 1, target);
        } else {
            return search(nums, mid + 1, end, target);
        }
    }
}
