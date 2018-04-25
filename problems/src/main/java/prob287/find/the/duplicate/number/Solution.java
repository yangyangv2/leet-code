package prob287.find.the.duplicate.number;

/**
 * Created by yanya04 on 8/7/2017.
 * Modified by yanya04 on 4/22/2018
 */
public class Solution {

    /*
        binary search:

        count the number of nums <= mid,
            if(more than mid) then definitly contains duplicate
    */
    public int findDuplicate(int[] nums) {


        int len = nums.length;
        int n = len - 1;

        int lo = 1, hi = n, mid = 0, count = 0;

        while(lo < hi){

            mid = lo + (hi - lo) / 2;

            // start counting the number of nums less than mid
            count = 0;
            for(int i = 0; i < len; i ++){
                if(nums[i] <= mid){
                    count ++;
                }
            }

            if(count > mid) {
                hi = mid;
            } else {
                // if count <= mid, it means fewer numbers are in [1:mid], so the duplicates must be in [mid + 1: n]
                // this only works if there's only duplicate number

                lo = mid + 1;
            }
        }

        return lo;
    }
}
