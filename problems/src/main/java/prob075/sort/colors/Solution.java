package prob075.sort.colors;

import java.util.Arrays;

/**
 * Created by yanya04 on 8/5/2017.
 * Modified by yanya04 on 5/1/2018.
 */
public class Solution {

/*
    Input:  [2,0,2,1,1,0]
             L         H
             i

            [0,0,2,1,1,2]
             L       H
             i

            [0,0,2,1,1,2]
               L     H
               i

    Output: [0,0,1,1,2,2]
*/


    public void sortColors(int[] nums) {

        int lo = 0, hi = nums.length - 1, i = 0;
        while(lo < hi && i <= hi){
            if(nums[i] == 0){
                swap(nums, i, lo);
                lo ++;
            } else if(nums[i] == 2){
                swap(nums, i, hi);
                hi --; i --;
            }
            i ++;
        }
    }


    private void swap(int[] nums, int i, int j){
        if(i == j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}