package prob239.sliding.window.maximum;

/**
 * Created by yanya04 on 9/3/2017.
 * Modified by yanya04 on 5/6/2018.
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    /*
        use a Deque to keep the index of the largest value
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0) return new int [0];

        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length, num = 0;

        int[] res = new int[n - k + 1];
        for(int i = 0; i < n; i ++){
            num = nums[i];
            while(!deque.isEmpty() && num >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);

            if(i - deque.peekFirst() == k){
                deque.pollFirst();
            }

            if(i >= k - 1){
                res[i - k + 1] = nums[deque.peekFirst()];
            }

        }
        return res;
    }
}

