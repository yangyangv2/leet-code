package prob661.image.smoother;

public class Solution {


    /*
        1,1,1   [0,1]
        1,0,1
        1,1,1

    */

    private int smooth(int[][] matrix, int i, int j){

        if(matrix.length < 1 || matrix[0].length < 1)
            return 0;

        if(matrix.length == 1 && matrix[0].length == 1)
            return matrix[0][0];

        int sum = matrix[i][j];
        int r = matrix.length;
        int c = matrix[0].length;
        int count = 1;

        // left

        if(j > 0){
            sum += matrix[i][j - 1];
            count ++;
        }

        // left-top
        if(j > 0 && i > 0){
            sum += matrix[i - 1][j - 1];
            count ++;
        }

        // left-bottom
        if(j > 0 && i < r - 1){
            sum += matrix[i + 1][j - 1];
            count ++;
        }

        // top
        if(i > 0){
            sum += matrix[i - 1][j];
            count ++;
        }

        // bottom
        if(i < r - 1){
            sum += matrix[i + 1][j];
            count ++;
        }

        // right
        if(j < c - 1){
            sum += matrix[i][j + 1];
            count ++;
        }

        // right-top
        if(j < c - 1 && i > 0){
            sum += matrix[i - 1][j + 1];
            count ++;
        }

        // right-bottom
        if(j < c - 1 && i < r - 1){
            sum += matrix[i + 1][j + 1];
            count ++;
        }


        return sum / count;
    }


    public int[][] imageSmoother(int[][] M) {
        int r = M.length, c = M[0].length;

        int[][] matrix = new int[r][c];
        for(int i = 0; i < r; i ++)
            for(int j = 0; j < c; j ++)
                matrix[i][j] = smooth(M, i, j);


        return matrix;
    }
}