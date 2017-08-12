package prob215.kth.largest.element.in.an.array;

import java.util.Random;

/**
 * Created by yanya04 on 8/12/2017.
 */
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] array = new int[]{1};
        System.out.println(solution2.findKthLargest(array, 1));
    }
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        return quickSelect(nums, k - 1);
    }


    private void shuffle(int[] nums){
        Random rand = new Random();
        for(int i = 0; i < nums.length; i ++){
            int randIdx = rand.nextInt(nums.length);
            swap(nums, i, randIdx);
        }
    }


    private int quickSelect(int [] nums, int k){

        int lo = 0, hi = nums.length - 1;

        int p = partition(nums, lo, hi);

        while(p != k){
            if(p > k){
                p = partition(nums, lo, p - 1);
            } else {
                p = partition(nums, p + 1, hi);
            }
        }
        return nums[p];
    }

    private int partition(int [] nums, int lo, int hi){
        int i = lo, j = hi, pivot = nums[hi];
        while(i < j){
            if(nums[i] < pivot){
                swap(nums, i, --j);
            } else {
                i ++;
            }
        }
        swap(nums, i, hi);
        return i;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
