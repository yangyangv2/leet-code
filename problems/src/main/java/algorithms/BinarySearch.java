package algorithms;

public class BinarySearch {

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


    public static void main(String[] args) {
        int arr[] = {2,4};
        int n = arr.length;
        int x = 5;

        System.out.println(binarySearch(arr, x));
    }
}
