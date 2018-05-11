package utils.test;

public class TestPartition {

    private static int[] nums = new int[]{1,2,3,3,3,3,3,3,3,5,6};

    public static void main(String[] args) {

        int target = 3;

        int loc0 = binarySearch(nums, target);
        int loc1 = findLeftMost(nums, target);
        int loc2 = findRightMost(nums, target);


        System.out.println(loc0);
        System.out.println(loc1);
        System.out.println(loc2);

    }

    //  return is either the target position or insert position
    private static int binarySearch(int[] nums, int target){

        int lo = 0, hi = nums.length - 1, mid = 0;

        while(lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    // return the right most position
    private static int findRightMost(int[] nums, int target){
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
        return lo;
    }

    // return the left post position
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
        return lo;
    }
}
