package prob154.find.minimum.in.rotated.sorted.array.ii;

/**
 * Created by yanya04 on 8/17/2017.
 * Modified by yanya04 on 5/12/2018.
 * Modified by yanya04 on 6/1/2018.
 */
public class Solution {
    public int findMin(int[] nums) {
        return nums[findPivot(nums)];
    }

    private int findPivot(int[] nums){
        int lo = 0, hi = nums.length - 1;

        while(lo < hi){

            int mid = lo + (hi - lo) / 2;

            if(nums[mid] > nums[hi]){
                lo = mid + 1;
            }
            else if(nums[mid] < nums[hi]){
                hi = mid;
            } else {
                hi --;
            }
        }
        return lo;
    }
}