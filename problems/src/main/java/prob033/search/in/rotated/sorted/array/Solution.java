package prob033.search.in.rotated.sorted.array;

/**
 * Created by yanya04 on 8/13/2017.
 * Modified by yanya04 on 5/14/2018.
 */
public class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid = 0, n = nums.length, idx = 0;
        int offset = findOffset(nums);
        while(lo <= hi){
            mid = lo + (hi - lo) / 2;
            idx = (mid + offset) % n;
            if(nums[idx] == target){
                return idx;
            } else if(nums[idx] < target){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return - 1;
    }

    private int findOffset(int[] nums){
        int lo = 0, hi = nums.length - 1, mid = 0;
        while(lo < hi){
            mid = lo + (hi - lo) / 2;
            if(nums[mid] > nums[hi]){
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
