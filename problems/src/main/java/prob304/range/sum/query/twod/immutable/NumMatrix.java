package prob304.range.sum.query.twod.immutable;

/**
 * Created by yanya04 on 2/6/2018.
 */
public class NumMatrix {

    private int[][] matrix;
    private int[][] sums;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        init();
    }

    private void init(){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            sums = new int[0][0];
            return;
        }

        int m = matrix.length, n = matrix[0].length;
        sums = new int[m][n];
        for(int i = 0; i < m; i ++){
            int sum = 0;
            for(int j = 0; j < n; j ++){
                int base = 0;
                if(i > 0){
                    base  += sums[i - 1][j];
                }
                sum += matrix[i][j];
                sums[i][j] = sum + base;
            }
        }
    }


    private int getSum(int x, int y){
        if(x < 0 || y < 0 || x >= sums.length || y >= sums[0].length) return 0;
        return sums[x][y];
    }


    public int sumRegion(int row1, int col1, int row2, int col2) {

        return getSum(row2, col2) - getSum(row2, col1 - 1)
                - getSum(row1 - 1, col2) + getSum(row1 - 1, col1 - 1);

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */