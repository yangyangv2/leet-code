package prob031.next.permutation;

import java.util.Arrays;

/**
 * Created by yanya04 on 7/23/2017.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,3,2};
        solution.nextPermutation(nums);
        for(Integer num: nums){
            System.out.print(num);
        }
    }

    private void reverse(int[] nums, int start, int end){
        for(int i = start, j = end; i < j; i ++, j --){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public void nextPermutation(int[] nums) {

        if(nums == null || nums.length <= 1) return ;

        for(int i = nums.length - 2; i >= 0; i --){
            if(nums[i] < nums[i + 1]){
                for(int j = nums.length - 1; j > i; j --){
                    if(nums[i] < nums[j]){
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        reverse(nums, i + 1, nums.length - 1);
                        return;
                    }
                }
            }
        }
        // if processed to here, sort the array and return the minimum
        reverse(nums, 0, nums.length - 1);
    }
}
