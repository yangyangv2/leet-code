package prob259.three.sum.smaller;

import java.util.Arrays;

/**
 * Created by yanya04 on 7/23/2017.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        assert solution.threeSumSmaller(new int[]{-2, 0, 1, 3}, 2) == 2;
    }
    /*
        Solution:

        1. sort array
        2. pick a number and do two sum ()
        3. if sum > target, break

    */

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            int sum = nums[i];
            while (l < r) {
                if (sum + nums[l] + nums[r] < target) {
                    count += (r - l);
                    l++;
                } else {
                    r--;
                }
            }
        }
        return count;
    }
}
