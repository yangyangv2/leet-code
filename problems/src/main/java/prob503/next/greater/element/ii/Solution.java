package prob503.next.greater.element.ii;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by yanya04 on 6/1/2018.
 */
public class Solution {
    /*

        1,2,1
        2-1,2
    */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length, count = 2 * n, index = 0;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        int actual = 0;
        while( index ++ < count){
            actual = index % n;
            while(!stack.isEmpty() && nums[actual] > nums[stack.peek()]){
                res[ stack.pop()] = nums[actual];
            }
            stack.push(actual);
        }

        return res;
    }
}
