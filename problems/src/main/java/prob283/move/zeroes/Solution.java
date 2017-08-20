package prob283.move.zeroes;

/**
 * Created by yanya04 on 8/20/2017.
 */
public class Solution {

    /*
        one time scan

        swap 1 zero
        swap 2 zeros
        ...

        1 2 0 0

                r
            w

    */

    public void moveZeroes(int[] nums) {


        int r = 0, w = 0;

        while(r < nums.length){
            while(r < nums.length && nums[r] == 0){
                r ++;
            }

            if(r > w && r < nums.length){
                swap(nums, r, w);
            }
            r ++;
            w ++;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
