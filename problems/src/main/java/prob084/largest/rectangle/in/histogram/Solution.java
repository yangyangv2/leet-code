package prob084.largest.rectangle.in.histogram;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by yanya04 on 1/6/2018.
 * Modified by yanya04 on 5/1/2018.
 * Modified by yanya04 on 5/6/2018.
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {

        if(heights == null || heights.length == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0, area = 0, hi = 0, w = 0, cur = 0, n = heights.length;
        for(int i = 0; i <= n; i ++){
            cur = (i == n)? -1: heights[i];
            while(! stack.isEmpty() && cur < heights[stack.peek()]){
                hi = stack.pop();
                w = stack.isEmpty() ? i : i - stack.peek() - 1;
                area = heights[hi] * w;
                max = Math.max(area, max);
            }
            stack.push(i);
        }
        return max;


    }
}