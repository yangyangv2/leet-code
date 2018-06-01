package prob540.single.element.in.a.sorted.array;

/**
 *  Created by yanya04 on 5/9/2018.
 *  Modified by yanya04 on 6/1/2018.
 */
public class Solution {
    /*
         0 1 2 3 4 5 6 7 8
        [1,1,2,2,3,4,4,8,8]
         L       M       R

         0 1 2 3 4 5 6
        [1,1,2,3,3,4,4]
         L     M     R
    */
    public int singleNonDuplicate(int[] nums) {
        if(nums == null ||nums.length == 0) return 0;

        int lo = 0, hi = nums.length - 1, mid = 0;

        while(lo < hi){
            mid = lo + (hi - lo) / 2;

            if(nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1])
                return nums[mid];

            if(mid % 2 == 0){
                if(nums[mid] == nums[mid + 1]){
                    lo = mid;
                } else {
                    hi = mid;
                }
            } else {
                if(nums[mid] == nums[mid + 1]){
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return nums[lo];
    }
}