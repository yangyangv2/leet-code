package prob048.rotate.image;

public class Solution {
    /*
    [ [0,0]     [0,2]
          [1,2,3],              [1,1]   [1,1]
          [4,5,6],              [1,1]   [1,1]
          [7,8,9]
      [2,0]     [2,2]
    ],

    [   n = 4

    [0,0]               [0,3]
          [ 5, 1, 9,11],
          [ 2, 4, 8,10],        [1,1]   [1,2]
          [13, 3, 6, 7],        [2,1]   [2,2]
          [15,14,12,16]
    [3,0]               [3,3]
    ],


    */
    private void transpose(int[][] matrix){
        if(matrix == null || matrix.length == 0)
            return;
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < n; i ++)
            for(int j = i; j < m; j ++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
    }

    // flip horizontally
    // if 90^ anticlockwise, flip vertically
    private void flip(int[][] matrix){
        if(matrix == null || matrix.length == 0)
            return;
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < n; i ++)
            for(int j = 0; j < m/2; j ++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][m - j - 1];
                matrix[i][m - j - 1] = temp;
            }

    }


    // 90^ clockwise => transpose, flip

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n < 2) return;

        transpose(matrix);
        flip(matrix);

    }
}