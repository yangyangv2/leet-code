package prob041.first.missing.positive;

/**
 * Created by yanya04 on 8/13/2017.
 */
public class Solution {

    /*
        3,4,-1,1                0       1       2

        3,4,MAX,1               1

       -3      -1
 -----------------------


    */
    public int firstMissingPositive(int[] nums) {

        int k = partition(nums);

        // all numbers before k are positive;

        for(int i = 0; i < k; i ++){
            int index = Math.abs(nums[i]) - 1;
            if(index < k){
                if(nums[index] > 0){
                    nums[index] = - nums[index];
                }
            }
        }

        for(int i = 0; i < k; i ++){
            if(nums[i] > 0)
                return i + 1;
        }

        return k + 1;
    }


    private void swap(int[] nums, int i, int j){
        if(i != j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    private int partition(int[] nums){

        int q = -1;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] > 0){
                q ++;
                swap(nums, q, i);
            }
        }

        return q + 1;
    }
}