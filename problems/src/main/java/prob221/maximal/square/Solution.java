package prob221.maximal.square;

import static java.lang.Math.*;

public class Solution {
    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;

        int[][] ms = new int[m][n];

        for(int c = 0; c < n; c ++)
            ms[0][c] = matrix[0][c] - '0';

        for(int r = 0; r < m; r ++)
            ms[r][0] = matrix[r][0] - '0';

        int max = 0;
        for(int r = 1; r < m; r ++)
            for(int c = 1; c < n; c ++){
                if(matrix[r][c] == '1'){
                    ms[r][c] = min(min(ms[r - 1][c], ms[r][c - 1]), ms[r - 1][c - 1]) + 1;
                    max = max(max, ms[r][c]);
                }
            }

        return max * max;
    }
}