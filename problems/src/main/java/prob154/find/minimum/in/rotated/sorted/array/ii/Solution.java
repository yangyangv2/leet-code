package prob154.find.minimum.in.rotated.sorted.array.ii;

/**
 * Created by yanya04 on 8/17/2017.
 */
public class Solution {

    public int findMin(int[] nums) {

        int lo = 0, hi = nums.length - 1, mid = 0;
        while(lo < hi){

            mid = lo + (hi - lo) / 2;
            if(nums[mid] > nums[hi]){
                lo = mid + 1;
            } else if(nums[mid] < nums[hi]){
                hi = mid;
            } else {

                // nums[mid] == nums[hi]

                // if lo is already at the pivot?   0 1 1 1 1       pivot = 0
                // if lo equals mid as well?        1 1 1 0 1       pivot = 3
                // if lo is the largest number      2 1 1 1 1       pivot = 1;

                if(nums[lo] == nums[mid]){
                    lo ++;
                } else{
                    hi = mid;
                }
            }
        }
        return nums[lo];
    }
}
