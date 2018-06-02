package prob410.split.array.largest.sum;

/**
 * Created by yanya04 on 6/2/2018.
 */
public class Solution {
    public int splitArray(int[] nums, int m) {
        int max = 0;
        long sum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }
        if (m == 1) return (int) sum;

        //binary search
        long lo = max; long hi = sum;
        while (lo <= hi) {
            long mid = lo + (hi - lo)/ 2;
            if (valid(mid, nums, m)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return (int)lo;
    }

    //  test if target is the largest sum

    public boolean valid(long target, int[] nums, int m) {
        int count = 1;
        long total = 0;
        for(int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}