package prob054.spiral.matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {

 /*
            top
         *------|*
    left _       |  right
         |       _
         *|------*
            bottom
*/

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        if(m == 0) return result;
        int n = matrix[0].length;

        int top = 0, right = n - 1, bottom = m - 1, left = 0;

        while(top < bottom && left < right){

            for(int j = left; j < right; j ++)
                result.add(matrix[top][j]);

            for(int j = top; j < bottom; j ++)
                result.add(matrix[j][right]);

            for(int j = right; j > left; j --)
                result.add(matrix[bottom][j]);

            for(int j = bottom; j > top; j --)
                result.add(matrix[j][top]);

            top ++; right --; bottom --; left ++;
        }

        if(left == right)
            for(int i = top; i <= bottom; i ++ )
                result.add(matrix[i][ n / 2 ]);
        else if(top == bottom)
            for(int i = left; i <= right; i ++ )
                result.add(matrix[m / 2][i]);


        return result;
    }
}