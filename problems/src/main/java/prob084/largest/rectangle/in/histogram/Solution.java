package prob084.largest.rectangle.in.histogram;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by yanya04 on 1/6/2018.
 * Modified by yanya04 on 5/1/2018.
 */
public class Solution {

    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i <= heights.length; i ++){
            int cur = (i == heights.length) ? -1 : heights[i];
            while(!stack.isEmpty() && cur < heights[stack.peek()]){
                int h = heights[stack.pop()];
                int area = h * (stack.isEmpty() ? i: (i - stack.peek() - 1));
                max = Math.max(area, max);
            }
            stack.push(i);
        }
        return max;
    }
}