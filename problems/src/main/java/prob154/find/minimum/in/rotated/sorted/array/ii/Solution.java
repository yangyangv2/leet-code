package prob154.find.minimum.in.rotated.sorted.array.ii;

/**
 * Created by yanya04 on 8/17/2017.
 * Modified by yanya04 on 5/12/2018.
 */
public class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1, mid = 0;
        while(lo < hi){
            mid = lo + ((hi - lo) >> 1);
            if(nums[mid] > nums[hi]){
                lo = mid + 1;
            } else if(nums[mid] < nums[hi]){
                hi = mid;
            } else {

                // nums[mid] == nums[hi]

                // 222201
                // 111101
                // 000010
                // 010000
                // 311111
                // 133333

                hi = hi - 1;
            }
        }
        return nums[lo];
    }
}