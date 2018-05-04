package prob215.kth.largest.element.in.an.array;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by yanya04 on 8/12/2017.
 * Modified by yanya04 on 5/4/2018.
 */
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        //return pq(nums, k);
        return quickselect(nums, k);
    }

    private int quickselect(int[] nums, int k){
        shuffle(nums);
        return qs(nums, 0, nums.length - 1, k - 1);
    }

    private int qs(int[] nums, int lo, int hi, int k){
        int p = 0;
        while(lo < hi){
            p = partition(nums, lo, hi);
            if(p == k) return nums[p];
            else if(p < k) lo = p + 1;
            else hi = p - 1;
        }
        return nums[lo];
    }

    private void shuffle(int nums[]) {
        final Random random = new Random();
        int j = 0;
        for(int i = 1; i < nums.length; i++) {
            swap(nums, i, random.nextInt(i + 1));
        }
    }

    private int partition(int[] nums, int lo, int hi){
        int i = lo, j = hi, p = nums[hi];
        while(i < j){
            if(nums[i] < p){
                swap(nums, i, --j);
            } else {
                i ++;
            }
        }
        swap(nums, i, hi);
        return i;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    private int pq(int[] nums, int k){

        // keep the k largest in reverse order
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums){
            pq.offer(num);
            if(pq.size() == k + 1){
                pq.poll();
            }
        }

        return pq.peek();
    }
}