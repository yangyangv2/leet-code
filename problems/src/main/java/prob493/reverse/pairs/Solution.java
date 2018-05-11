package prob493.reverse.pairs;

import java.util.Arrays;

/**
 * Created by yanya04 on 8/10/2017.
 * Modified by yanya04 on 5/10/2018.
 */
public class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int l, int r){
        if(l >= r) return 0;

        int m = l + (r - l) / 2;
        int res = mergeSort(nums, l, m) + mergeSort(nums, m + 1, r);

        int i = l, j = m + 1;
        while(i <= m && j <= r){
            if (nums[i] > nums[j] * 2L){
                res += m - i + 1;
                j++;
            }
            else{
                i++;
            }
        }

        merge(nums, l, r);
        return res;

    }


    private void merge(int[] nums, int lo, int hi){
        int mid = lo + (hi - lo) / 2;
        int[] merge = new int[hi - lo + 1];

        int i = lo, j = mid + 1, k = 0;
        int num1 = 0, num2 = 0;
        while (k < merge.length){
            num1 = i > mid ? Integer.MAX_VALUE : nums[i];
            num2 = j > hi ? Integer.MAX_VALUE : nums[j];
            merge[k++] = num1 <= num2 ? nums[i++] : nums[j++];
        }
        System.arraycopy(merge, 0, nums, lo, merge.length);
    }
}