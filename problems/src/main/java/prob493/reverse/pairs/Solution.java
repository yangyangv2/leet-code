package prob493.reverse.pairs;

import java.util.Arrays;

/**
 * Created by yanya04 on 8/10/2017.
 * Modified by yanya04 on 5/10/2018.
 * Modified by yanya04 on 5/25/2018.
 */
public class Solution {
    /*
        merge sort
        split nums into sorted [...i...] mid [...j...]
        for each nums[i] > nums[j * 2], count += mid - i + 1;

    */
    public int reversePairs(int[] nums) {

        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int lo, int hi){
        if(lo >= hi) return 0;
        int mid = lo + (hi - lo) / 2;

        int count = mergeSort(nums, lo, mid) + mergeSort(nums, mid + 1, hi);

        // halvely sorted nums [... sorted ... mid] [mid + 1 ... sorted ...]

        int i = lo, j = mid + 1;
        while(i <= mid && j <= hi){
            if(nums[i] > nums[j] * 2L){
                count += mid - i + 1;
                j ++;
            } else {
                i ++;
            }
        }

        merge(nums, lo, mid, hi);

        return count;
    }


    private void merge(int[] nums, int lo, int mid, int hi){

        int i = lo, j = mid + 1, k = 0;
        int[] merge = new int[hi - lo + 1];
        while(k < merge.length){
            int num1 = i > mid ? Integer.MAX_VALUE : nums[i];
            int num2 = j > hi ? Integer.MAX_VALUE: nums[j];
            merge[k ++] = num1 <= num2 ? nums[i ++] : nums[j ++];
        }

        System.arraycopy(merge, 0, nums, lo, merge.length);
    }
}