package prob308.range.sum.query.twod.mutable;

/**
 * Created by yanya04 on 2/7/2018.
 * Modified by yanya04 on 5/10/2018.
 * Modified by yanya04 on 5/31/2018.
 */
public class NumMatrix {

    class BIT{

        int[][] matrix, bits;
        int m, n;

        BIT(int[][] matrix){
            this.m = matrix.length;
            if(m == 0) return;
            this.n = matrix[0].length;
            this.matrix = new int[m][n];
            this.bits = new int[m + 1][n + 1];

            for(int i = 0; i < m; i ++){
                for(int j = 0; j < n; j++){
                    update(i, j, matrix[i][j]);
                }
            }
        }

        void update(int row, int col, int val){
            int delta = val - matrix[row][col];
            matrix[row][col] = val;
            for(int i = row + 1; i > 0; i -= (i & - i)){
                for(int j = col + 1; j > 0; j -= (j & - j)){
                    bits[i][j] += delta;
                }
            }
        }

        int sum(int row, int col){
            int sum = 0;
            for(int i = row + 1; i < m + 1; i += (i & -i)){
                for(int j = col + 1; j < n + 1; j += (j & - j)){
                    sum += bits[i][j];
                }
            }
            return sum;
        }
    }

    private BIT bit;
    public NumMatrix(int[][] matrix) {
        bit = new BIT(matrix);
    }

    public void update(int row, int col, int val) {
        bit.update(row, col, val);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        if (bit.m == 0 || bit.n  == 0) return 0;
        return bit.sum(row2 + 1, col2 + 1) + bit.sum(row1, col1) -
                bit.sum(row1, col2 + 1) - bit.sum(row2 + 1, col1);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
