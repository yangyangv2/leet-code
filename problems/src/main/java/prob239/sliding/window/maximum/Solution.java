package prob239.sliding.window.maximum;

/**
 * Created by yanya04 on 9/3/2017.
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    /*
        Monotonic Queue:

        Window position                Max
        ---------------               -----
        [1  3  -1] -3  5  3  6  7       3
         1 [3  -1  -3] 5  3  6  7       3
         1  3 [-1  -3  5] 3  6  7       5
         1  3  -1 [-3  5  3] 6  7       5
         1  3  -1  -3 [5  3  6] 7       6
         1  3  -1  -3  5 [3  6  7]      7

         monotonic queue keeps the largest element a up to position i

    1   [1]
    2   [3]
    3   [3,-1]
    4   [3,-1,-3]
    5   [5]         // remove 3, pop up -1, -3
    6   [5,3]
    7   [6]         // pup up 5, 3
    8   [7]         // pop up 6

    */
    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums.length == 0) return new int[0];

        Deque<Integer> queue = new ArrayDeque<>();

        int[] result = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length; i ++){

            int num = nums[i];

            if(!queue.isEmpty() && queue.peek() <= i - k ){ // index
                queue.poll();
            }
            // enque
            while(!queue.isEmpty() &&  nums[queue.peekLast()] <= num ) {
                queue.pollLast();
            }
            queue.add(i);

            if(i >= k - 1){
                result[i - k + 1] = nums[queue.peek()];
            }
        }
        return result;
    }
}


