package utils.test;

import java.util.Arrays;

public class TestPartition {

    private static int[] nums = new int[]{1,2,3,3,3,3,3,3,3,3,4,5};

    public static void main(String[] args) {

        int loc1 = findLeftMost(nums, 3);
        int loc2 = findRightMode(nums, 3);

        System.out.println(loc2 - loc1 + 1);
    }


    private static int findRightMode(int[] nums, int target){
        int lo = 0, hi = nums.length - 1, mid = 0;

        while(lo <= hi){
            mid = lo + (hi - lo) / 2;
            if( nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] != target) ){
                return mid;
            } else if(nums[mid] > target){
                hi = mid - 1;
            } else {
                lo = mid + 1;   // shrink from left to the right
            }
        }
        return - 1;
    }


    private static int findLeftMost(int[] nums, int target){

        int lo = 0, hi = nums.length - 1, mid = 0;

        while(lo <= hi){
            mid = lo + (hi - lo) / 2;
            if( nums[mid] == target && (mid == 0 || nums[mid - 1] != target) ){
                return mid;
            } else if(nums[mid] < target){
                lo = mid + 1;
            } else {
                hi = mid - 1;   // shrink from right to the left
            }
        }
        return - 1;
    }
}
