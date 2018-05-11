package prob327.count.of.range.sum;

/**
 * Created by yanya04 on 5/11/2018.
 */
public class Solution {

    public int countRangeSum(int[] nums, int lower, int upper) {

        long[] presum = new long[nums.length + 1];
        for(int i = 0; i < nums.length; i ++){
            presum[i + 1] = presum[i] + nums[i];
        }

        return mergeSort(presum, 0, presum.length - 1, lower, upper);
    }

    private int mergeSort(long[] nums, int l, int r, int lower, int upper){
        if(l >= r) return 0;

        int m = l + (r - l) / 2;
        int res = mergeSort(nums, l, m, lower, upper) + mergeSort(nums, m + 1, r, lower, upper);

        int p1 = m + 1, p2 = m + 1;
        for (int y = l; y <= m; y++){
            while (p1 <= r && nums[p1] - nums[y] < lower) p1++;
            while (p2 <= r && nums[p2] - nums[y] <= upper) p2++;
            res += p2 - p1;
        }

        merge(nums, l, r);

        return res;
    }


    private void merge(long[] nums, int lo, int hi){
        int mid = lo + (hi - lo) / 2;
        long[] merge = new long[hi - lo + 1];

        int i = lo, j = mid + 1, k = 0;
        long num1 = 0, num2 = 0;
        while (k < merge.length){
            num1 = i > mid ? Long.MAX_VALUE : nums[i];
            num2 = j > hi ? Long.MAX_VALUE : nums[j];
            merge[k++] = num1 <= num2 ? nums[i++] : nums[j++];
        }
        System.arraycopy(merge, 0, nums, lo, merge.length);
    }

}