package prob304.range.sum.query.twod.immutable;

/**
 * Created by yanya04 on 2/6/2018.
 * Modified by yanya04 on 5/31/2018.
 */
public class NumMatrix {

    private int[][] sums;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return;
        int n = matrix[0].length;
        sums = new int[m + 1][n + 1];
        for(int i = 0; i < m; i ++){
            int sum = 0;
            for(int j = 0; j < n ; j ++){
                sum += matrix[i][j];
                sums[i + 1][j + 1] = sum;
                if(i > 0) sums[i + 1][j + 1] += sums[i][j + 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] + sums[row1][col1] - sums[row1][col2 + 1] -sums[row2 + 1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */