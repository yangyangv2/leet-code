package prob308.range.sum.query.twod.mutable;

/**
 * Created by yanya04 on 2/7/2018.
 * Modified by yanya04 on 5/10/2018.
 */
public class NumMatrix {

        class BIT{
            int[][] nums, sums;
            int m, n;

            BIT (int [][] matrix){
                m = matrix.length;
                if(m == 0) return;
                n = matrix[0].length;
                this.nums = new int[m][n];
                this.sums = new int[m + 1][n + 1];

                for(int i = 0; i < m; i ++){
                    for(int j = 0; j < n; j ++){
                        update(i, j, matrix[i][j]);
                    }
                }
            }

            void update(int row, int col, int val){

                if(m == 0 || n == 0) return;
                int delta = val - nums[row][col];
                nums[row][col] = val;

                int i = row + 1;
                while(i <= m){
                    int j = col + 1;
                    while(j <= n){
                        sums[i][j] += delta;
                        j += j & (-j);
                    }
                    i += i & (-i);
                }
            }

            int sum(int row, int col){

                if(m == 0 || n == 0) return 0;

                int sum = 0;
                int i = row + 1;
                while(i > 0){
                    int j = col + 1;
                    while(j > 0){
                        sum += sums[i][j];
                        j -= j & (-j);
                    }
                    i -= i & (-i);
                }
                return sum;
            }
        }

        BIT bit;

        public NumMatrix(int[][] matrix) {
            bit = new BIT(matrix);
        }

        public void update(int row, int col, int val) {
            bit.update(row, col, val);
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (bit.m == 0 || bit.n == 0) return 0;
            return bit.sum(row2, col2) + bit.sum(row1 - 1, col1 - 1) -
                    bit.sum(row1 - 1, col2) - bit.sum(row2, col1 - 1);
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
