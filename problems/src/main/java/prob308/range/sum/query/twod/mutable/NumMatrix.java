package prob308.range.sum.query.twod.mutable;

/**
 * Created by yanya04 on 2/7/2018.
 */
public class NumMatrix {

    private int[][] matrix;
    private int[][] bits;

    public NumMatrix(int[][] matrix) {

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            this.matrix = new int[1][0];
        } else {
            this.matrix = matrix;
            init();
        }
    }

    private void init(){
        int m = matrix.length, n = matrix[0].length;
        bits = new int[m + 1][n + 1];
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                add(i, j, matrix[i][j]);
            }
        }
    }

    private void add(int row, int col, int val){
        row ++; col ++;
        int m = bits.length, n = bits[0].length;
        int i = row;
        while(i < m){
            int j = col;
            while(j < n){
                bits[i][j] += val;
                j += (j & -j);
            }
            i += (i & -i);
        }
    }

    public void update(int row, int col, int val) {
        int diff = val - matrix[row][col];
        matrix[row][col] = val;
        add(row, col, diff);
    }

    private int getSum(int row, int col){
        int sum = 0;
        row ++; col ++;
        int i = row;
        while(i > 0){
            int j = col;
            while(j >0){
                sum += bits[i][j];
                j -= (j & -j);
            }
            i -= (i & -i);
        }
        return sum;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {


        return getSum(row2, col2) + getSum(row1 - 1, col1 - 1) - getSum(row2, col1 - 1) - getSum(row1 - 1, col2) ;

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
