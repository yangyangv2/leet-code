package prob315.count.of.smaller.numbers.after.self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yanya04 on 3/5/2018.
 * Modified by yanya04 on 5/10/2018.
 * Modified by yanya04 on 5/26/2018.
 */
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[] counts = new int[nums.length];
        mergeSort(nums, counts, 0, nums.length - 1);
        List<Integer> res = new ArrayList<>();
        for(int count: counts){
            res.add(count);
        }
        return res;
    }

    private void mergeSort(int[] nums, int[] counts, int lo, int hi){

        if(lo >= hi) return;

        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, counts, mid + 1, hi);

        for(int i = lo; i <= mid; i ++){
            counts[i] += countSmaller(nums, mid + 1, hi, nums[i]);
        }

        mergeSort(nums, counts, lo, mid);
        merge(nums, lo, mid, hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi){

        int[] merge = new int[hi - lo + 1];

        int i = lo, j = mid + 1, index = 0;
        while(index < merge.length){
            int num1 = (i > mid) ? Integer.MAX_VALUE: nums[i];
            int num2 = (j > hi) ? Integer.MAX_VALUE: nums[j];
            merge[index ++] = num1 < num2 ? nums[i ++] : nums[j ++ ];
        }
        System.arraycopy(merge, 0, nums, lo, merge.length);
    }


    private int countSmaller(int[] nums, int lo, int hi, int target) {
        // find left most

        int mid = 0, i = lo, j = hi;

        int res = 0;
        while(i <= j){
            mid = i + (j - i) / 2;
            if(nums[mid] == target && (mid == lo || nums[mid - 1] != target )){
                i = mid;
                break;
            } else if(nums[mid] < target){
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        // 4 cases
        // i < lo => 0
        // i > hi => hi - lo + 1
        // i == lo && nums[i] == target => 0
        // others i - lo;

        if(i < lo){
            return 0;
        } else if(i > hi){
            return hi - lo + 1;
        } else if(nums[i] == target && i == lo){
            return 0;
        } else {
            return i - lo;
        }
    }
}