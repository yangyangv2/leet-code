package prob221.maximal.square;

/**
 * Modified by yanya04 on 5/7/2018.
 */
public class Solution {

    /*
        let f[i][j] be the max lens of the square.
        f[i][j] = min(f[i][j - 1], f[i - 1][j], f[i - 1][j - 1]) + 1
    */
    public int maximalSquare(char[][] matrix) {

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int m = matrix.length, n = matrix[0].length, max = 0;
        int[][] f = new int[2][n + 1];
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(matrix[i][j] == '1'){
                    f[(i + 1)%2][j + 1] = Math.min(Math.min(f[i%2][j + 1], f[(i + 1)%2][j]), f[i%2][j]) + 1;
                    max = Math.max(f[(i + 1)%2][j + 1] * f[(i + 1)%2][j + 1], max);
                } else {
                    f[(i + 1)%2][j + 1] = 0;
                }
            }
        }
        return max;
    }
}