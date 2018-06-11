package prob031.next.permutation;

import java.util.Arrays;

/**
 * Created by yanya04 on 7/23/2017.
 * Modified by yanya04 on 5/20/2018.
 * Modified by yanya04 on 6/10/2018.
 */
public class Solution {
    public void nextPermutation(int[] nums) {

        if(nums == null || nums.length < 2) return;
        int n = nums.length;
        for(int i = n - 2; i >= 0; i --){
            if(nums[i] > nums[i + 1]) continue;
            for(int j = n - 1; j > i; j --){
                if(nums[j] > nums[i]){
                    swap(nums, i, j);
                    reverse(nums, i + 1, n - 1);
                    return;
                }
            }
        }
        reverse(nums, 0, n - 1);
    }

    private void reverse(int[] nums, int lo, int hi){
        while(lo < hi){
            swap(nums, lo, hi);
            lo ++;
            hi --;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}