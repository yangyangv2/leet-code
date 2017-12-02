package prob120.triangle;

import java.util.List;

public class Solution {
    /*
    f(i, j) = at level i, it moves to position j

    init: f(0, 0);
    1:    min of f(0, 0) + f(1, 0) and f(0, 0) + f(1, 1)
    2:    min of f(1, 0) + f(2, 0) and f(1, 0) + f(2, 1) and
                 f(1, 1) + f(2, 1) and f(1, 1) + f(2, 2)

    3:    ... ...


    */
    public int minimumTotal(List<List<Integer>> triangle) {

        int m = triangle.size();
        int[][] min = new int[m][m];

        min[0][0] = triangle.get(0).get(0);

        for(int i = 1; i < m; i ++){
            min[i][0] = min[i - 1][0] + triangle.get(i).get(0);
            min[i][i] = min[i - 1][i - 1] + triangle.get(i).get(i);
        }

        for(int i = 1; i < m; i ++){
            for(int j = 1; j < i; j ++){
                min[i][j] = Math.min(min[i - 1][j], min[i - 1][j - 1]) + triangle.get(i).get(j);
            }
        }

        int s = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            s = Math.min(min[m - 1][i], s);
        }

        return s;
    }
}