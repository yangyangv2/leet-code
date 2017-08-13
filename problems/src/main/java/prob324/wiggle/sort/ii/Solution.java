package prob324.wiggle.sort.ii;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by yanya04 on 8/13/2017.
 */
public class Solution {
    /*
    idea:

    find median and get into two groups.
    (small) median (large)
    add them in
*/

    public void wiggleSort(int[] nums) {

        if(nums == null || nums.length < 2){
            return;
        }
        shuffle(nums);
        int m = medianPartition(nums);


        int median = nums[m];
        int n = nums.length;

        int firstOdd = 1;
        int lastEven;
        if(n % 2 == 1){
            lastEven = n - 1;
        } else {
            lastEven = n - 2;
        }

        int[] nums2 = new int[n];
        boolean[] map = new boolean[n];
        Arrays.fill(map, false);

        // fill L
        int s = firstOdd;
        for(int i = m; i < n; i ++){
            if(nums[i] == nums[m]) continue;
            nums2[s] = nums[i];
            map[s] = true;
            s += 2;
            if(s >= n) break;
        }
        s = lastEven;

        // fill S
        for(int i = m; i >= 0; i --){
            if(nums[i] == nums[m]) continue;
            nums2[s] = nums[i];
            map[s] = true;
            s -= 2;
            if(s < 0) break;
        }

        // fill M
        for(int i = 0; i < n; i ++){
            if(!map[i]){
                nums2[i] = median;
            }
        }

        for(int i = 0; i < n; i ++){
            nums[i] = nums2[i];
        }
    }


    private void shuffle(int[] nums){
        Random rand = new Random();
        for(int i = 0; i < nums.length; i ++){
            swap(nums, i, rand.nextInt(nums.length));
        }
    }


    private int medianPartition(int[] nums){

        int lo = 0, hi = nums.length - 1;

        int j = partition(nums, lo, hi);
        int m = nums.length / 2;
        while(j != m){
            if(j > m) {
                j = partition(nums, lo, j - 1);
            } else {
                j = partition(nums, j + 1, hi);
            }
        }
        return m;
    }


    private int partition(int[] nums, int lo, int hi){
        int i = lo, j = hi, pivot = nums[hi];
        while(i < j){
            if(nums[i] > pivot){
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
