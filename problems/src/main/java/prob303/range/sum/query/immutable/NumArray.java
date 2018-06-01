package prob303.range.sum.query.immutable;

/**
 * Created by yanya04 on 8/18/2017.
 * Modified by yanay04 on 5/31/2018.
 */
public class NumArray {
    private int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length];
        for(int i = 0; i < nums.length; i ++){
            sums[i] = nums[i];
            if(i > 0) sums[i] += sums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        i --;
        if(i < 0) return sums[j];
        else return sums[j] - sums[i];
    }
}
