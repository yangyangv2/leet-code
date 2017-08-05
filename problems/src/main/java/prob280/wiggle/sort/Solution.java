package prob280.wiggle.sort;

/**
 * Created by yanya04 on 8/5/2017.
 */
public class Solution {
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void wiggleSort(int[] nums) {

        if(nums == null) return;

        for(int i = 0; i < nums.length - 1; i ++){
            if(i % 2 == 0 && nums[i] > nums[i + 1]){
                swap(nums, i, i + 1);
            } else if (i % 2 == 1 && nums[i] < nums[i + 1]) {
                swap(nums, i, i + 1);
            }
        }
    }
}
