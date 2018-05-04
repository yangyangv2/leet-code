package prob085.maximal.rectangle;

import java.util.ArrayDeque;
import java.util.Deque;
/**
 * Created by yanya04 on 1/6/2018.
 * Modified by yanya04 on 5/1/2018.
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int m = matrix.length, n = matrix[0].length;

        int[] heights = new int[n];
        int max = 0, h = 0, w = 0, cur = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < m; i ++){
            // build the height
            for(int j = 0; j < n; j ++){
                if (matrix[i][j] == '0') heights[j] = 0;
                else heights[j] += 1;
            }

            // histgram problem
            stack.clear();
            for(int j = 0; j <= n; j ++){
                cur = (j == n) ? - 1: heights[j];
                while(!stack.isEmpty() && cur < heights[stack.peek()]){
                    h = heights[stack.pop()];
                    w = stack.isEmpty() ? j: (j - stack.peek() - 1);
                    max = Math.max(h * w, max);
                }
                stack.push(j);
            }
        }
        return max;
    }
}