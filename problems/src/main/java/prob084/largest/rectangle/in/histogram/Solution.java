package prob084.largest.rectangle.in.histogram;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by yanya04 on 1/6/2018.
 * Modified by yanya04 on 5/1/2018.
 * Modified by yanya04 on 5/6/2018.
 * Modified by yanya04 on 6/1/2018.
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {

        Deque<Integer> stack = new ArrayDeque<>();
        int n = heights.length, max = 0, area = 0, w = 0, h = 0, cur = 0;
        for(int i = 0; i <= n; i ++){

            cur = (i == n) ? -1 : heights[i];
            while(!stack.isEmpty() && cur < heights[stack.peek()]){
                h = stack.pop();
                w = stack.isEmpty()? i : i - stack.peek() - 1;
                area = w * heights[h];
                max = Math.max(area, max);
            }
            stack.push(i);
        }
        return max;
    }
}