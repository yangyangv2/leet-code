package prob033.search.in.rotated.sorted.array;

/**
 * Created by yanya04 on 8/13/2017.
 */
public class Solution {
    public int search(int[] nums, int target) {

        int n = nums.length;
        if(n == 0) return -1;

        int offset = findRotateOffset(nums);

        int lo = 0 + offset, hi = nums.length + offset, mid = 0, idx = 0;
        while(lo <= hi){
            mid = lo + (hi - lo) / 2;
            idx = mid % n;
            if(nums[idx] < target){
                lo = mid + 1;
            } else if(nums[idx] > target){
                hi = mid - 1;
            } else {
                return idx;
            }
        }
        return -1;

    }

    /*
        return the roate offset

        O(n) -> O(n*log(n))

    idx 0 1 2 3 4 5 6
        4 5 6 7 0 1 2
        7 0 1 2 4 5 6
    */
    private int findRotateOffset(int[] nums){
        int n = nums.length;
        int lo = 0, hi = n - 1, mid = 0;

        while(lo < hi){
            mid = lo + (hi - lo) / 2;
            if(nums[mid] > nums[hi]){
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;

        /* O(n)
        int n = nums.length;
        for(int i = 1; i < n; i ++){
            if(nums[i - 1] > nums[i]){
                return i;
            }
        }
        return 0;
        */
    }

}
