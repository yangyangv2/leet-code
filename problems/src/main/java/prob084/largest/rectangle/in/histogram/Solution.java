package prob084.largest.rectangle.in.histogram;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by yanya04 on 1/6/2018.
 */
public class Solution {
    /*
        1. bruteforce solution
        2. dp approach
        3. stack based solution
    */
    public int largestRectangleArea(int[] heights) {
        // return bruteforce(heights);
        // return dp(heights);
        return stack(heights);
    }



    private int stack(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int maxarea = 0;
        for(int i = 0; i <= n; i ++){
            int h = (i == n)? 0: heights[i];
            while( !stack.isEmpty() && h < heights[stack.peek()]){
                int curHeight = heights[stack.pop()];
                int preIndex = stack.isEmpty() ? -1 : stack.peek();
                int area = (i - preIndex - 1) * curHeight;
                maxarea = Math.max(area, maxarea);
            }
            stack.push(i);
        }
        return maxarea;
    }




/*
    left[i]:    the left position of the first element which is smaller than height[i]
    right[i]:   the right position of the first element which is smaller than height[i];
*/

    private int dp(int[] heights){
        int n = heights.length;
        int[] lefts = new int[n];
        int[] rights = new int[n];
        Arrays.fill(lefts, -1);
        Arrays.fill(rights, n);

        for(int i = 1; i < n; i ++){
            // calculate lefts
            for(int j = i - 1; j >= 0;){
                if(heights[j] < heights[i]){
                    lefts[i] = j;
                    break;
                } else {
                    // heights[j] >= heights[i]
                    if(lefts[j] == -1)
                        break;
                    else
                        j = lefts[j];
                }
            }
        }

        for(int i = n - 2; i >= 0; i--){
            // calculate rights
            for(int j = i + 1; j < n;){
                if(heights[j] < heights[i]){
                    rights[i] = j;
                    break;
                } else {
                    // heights[j] >= heights[i]
                    if(rights[j] == n)
                        break;
                    else
                        j = rights[j];
                }
            }
        }

        int area = 0;
        for(int i = 0; i < n ; i ++){
            area = Math.max(area, (rights[i] - lefts[i] - 1) * heights[i]);
        }
        return area;
    }

    private int bruteforce(int[] heights){
        int n = heights.length;
        if(n == 0) return 0;

        int maxarea = heights[0];
        for(int i = 1; i < n; i ++){
            if(i == n - 1 || heights[i] > heights[i + 1]){
                int localmax = heights[i];
                int minheight = heights[i];
                for(int j = i - 1; j >= 0; j --){
                    minheight = Math.min(minheight, heights[j]);
                    localmax = Math.max(localmax, minheight * (i - j + 1));
                }
                maxarea = Math.max(localmax, maxarea);
            }
        }
        return maxarea;
    }
}