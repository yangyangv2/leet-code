package prob096.unique.binary.search.trees;

/**
 * Created by yanya04 on 1/8/2018.
 */
public class Solution {

    // nums[i]  number of trees of [i]
    // tree[i,j] = when root is [i], total number is [j]

    public int numTrees(int n) {
        int[] nums = new int[n + 1];
        nums[0] = nums[1] = 1;

        for(int i = 2; i <= n; i ++){
            for(int j = 1; j <= i; j ++){
                nums[i] += nums[j - 1] * nums[i - j];
            }
        }

        return nums[n];
    }
}
