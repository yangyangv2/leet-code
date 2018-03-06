package prob311.sparse.matrix.multiplication;

/**
 * Created by yanya04 on 3/5/2018.
 */
public class Solution {
    /*
         |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
    AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                      | 0 0 1 |

         [2] x 3        3 x [3]

    */
    public int[][] multiply(int[][] A, int[][] B) {
        int m1 = A.length, n1 = A[0].length;
        int m2 = B.length, n2 = B[0].length;
        int[][] res = new int[m1][n2];
        for(int i = 0; i < m1; i ++)
        {
            for(int k = 0; k < n1; k ++)
            {
                if(A[i][k] == 0) continue;
                for(int j = 0; j < n2; j ++)
                {
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return res;
    }
}
