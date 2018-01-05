package prob073.set.matrix.zeroes;

/**
 * Created by yanya04 on 1/4/2018.
 */
public class Solution {
/*
    in place solution
*/

    public void setZeroes(int[][] matrix) {

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;

        // mark if the first row/column has zero
        boolean row = false, col = false;
        for(int i = 0; i < matrix.length; i ++)
            for(int j = 0; j < matrix[i].length; j ++){
                if(matrix[i][j] != 0)
                    continue;

                if(i == 0) col = true;
                if(j == 0) row = true;

                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }


        for(int i = 1; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                for(int j = 1; j < matrix[0].length; j ++)
                    matrix[i][j] = 0;
            }
        }

        for(int j = 1; j < matrix[0].length; j ++){
            if(matrix[0][j] == 0){
                for(int i = 1; i < matrix.length; i ++)
                    matrix[i][j] = 0;
            }
        }


        if(row){
            for(int i = 0; i < matrix.length; i ++)
                matrix[i][0] = 0;
        }

        if(col){
            for(int j = 0; j < matrix[0].length; j ++)
                matrix[0][j] = 0;
        }
    }
}