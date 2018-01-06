package prob085.maximal.rectangle;

import java.util.Stack;

/**
 * Created by yanya04 on 1/6/2018.
 */
public class Solution {
    /*
        left[]
        right[]
        height[]
        res : (right[j] - left[j]) * height[j]

    */
    public int maximalRectangle(char[][] matrix) {

        if(matrix == null || matrix.length == 0) return 0;

        int m = matrix.length, n = matrix[0].length;

        int[] heights = new int[n];

        int maxarea = 0;

        for(int i = 0; i < m; i ++){
            // calculate height
            if(i == 0)
                for(int j = 0; j < n; j ++) heights[j] = matrix[0][j] - '0';
            else {
                for(int j = 0; j < n; j ++){
                    if(matrix[i][j] == '1'){
                        heights[j] = heights[j] + 1;
                    } else {
                        heights[j] = 0;
                    }
                }
            }

            // calculate maximum histogram area
            Stack<Integer> stack = new Stack<>();

            for(int j = 0; j <= n; j ++){
                int h = (j == n)? 0: heights[j];
                while( !stack.isEmpty() && h <= heights[stack.peek()]){
                    int curHeight = heights[stack.pop()];
                    int preIndex = stack.isEmpty()? -1 : stack.peek();
                    int localarea = curHeight * (j - preIndex - 1);
                    maxarea = Math.max(maxarea, localarea);
                }
                stack.push(j);
            }
        }
        return maxarea;
    }
}
