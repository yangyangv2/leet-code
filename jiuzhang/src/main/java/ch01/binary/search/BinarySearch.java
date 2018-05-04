package ch01.binary.search;

/**
 * Created by yanya04 on 4/17/2018.
 */
public class BinarySearch
{
    private static int[] nums = new int[]{1, 1, 1, 3, 3, 3, 5, 6};
    private static int findTarget(int target){
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
        return -1;
    }

    private static int findLeftPos(int target){

        int lo = 0, hi = nums.length - 1, mid = 0;
        while(lo <= hi){
            mid = lo + (hi - lo) / 2;

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

    private static int findRightPos(int target){
        int lo = 0, hi = nums.length - 1, mid = 0;
        while(lo <= hi){
            mid = lo + (hi - lo) / 2;
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



    public static void main(String[] args)
    {
        System.out.println(findTarget(3));
        System.out.println(findLeftPos(3));
        System.out.println(findRightPos(3));
    }
}
