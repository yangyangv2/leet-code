package prob312.burst.balloons;

/**
 * Created by yanya04 on 3/5/2018.
 * Modified by yanya04 on 5/8/2018.
 */
public class Solution {
    /*
        f[i][j] = max coins to get at range [i, j]
        f[i][j] = max{ f[i][k - 1] + f[k + 1][j] + nums[k - 1] * nums[k + 1] * nums[k]  }
    */
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] nums2 = new int[n + 2];
        System.arraycopy(nums, 0, nums2, 1, n);
        nums2[0] = nums2[n + 1] = 1;
        int[][] f = new int[n + 2][n + 2];
        search(f, nums2, 1, n);

        return f[1][n];
    }


    private int search(int[][] f, int[] nums, int start, int end){
        int max = 0;

        if(f[start][end] > 0) return f[start][end];

        for(int k = start; k <= end; k ++){

            int left = search(f, nums, start, k - 1);
            int right = search(f, nums, k + 1, end);
            max = Math.max(left + right + nums[start - 1] * nums[k] * nums[end + 1], max);
        }
        f[start][end] = max;
        return max;

    }

}