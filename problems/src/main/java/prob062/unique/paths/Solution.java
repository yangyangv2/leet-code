package prob062.unique.paths;

import java.util.Arrays;

public class Solution {
    public int uniquePaths(int m, int n) {

        // path[i][j] is the number of paths to get path[i][j] from [0][0];

        // O(m * n) complexity, O(n) space

        int[] pre = new int[n];
        int[] cur = new int[n];

        // initialization
        Arrays.fill(pre, 1);
        cur[0] = 1;

        // path[i][j] = path[i - 1][j] + path[i][j - 1];
        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j ++)
                cur[j] = pre[j] + cur[j -1];
            pre = cur;
            cur = new int[n];
            cur[0] = 1;
        }
        return pre[n - 1];
    }
}