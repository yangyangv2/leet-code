package prob189.rotate.array;

/**
 * Created by yanya04 on 9/10/2017.
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;

        /* WordDictionary 1, with extra space

        int[] temp = Arrays.copyOf(nums, len);

        for(int i = 0; i < len; i ++){
            nums[(i + k) % len] = temp[i];
        }*/

        /* WordDictionary 2, in place 3-reverses */

        k = k % len;

        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);

    }

    private void reverse(int[] nums, int start, int end){
        int i = start, j = end;
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j --;
        }
    }
}
