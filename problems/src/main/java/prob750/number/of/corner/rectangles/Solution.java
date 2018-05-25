package prob750.number.of.corner.rectangles;

/**
 *  Created by yanya04 on 5/23/2018.
 */
public class Solution {

    /*
         [1, 0, 0, 1, 0],
         [0, 0, 1, 0, 1],
         [0, 0, 0, 1, 0],
         [1, 0, 1, 0, 1]

    */
    public int countCornerRectangles(int[][] grid) {
        int res = 0, counter = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m - 1; i++) {           //  fixed 1st row
            for (int j = i + 1; j < m; j++) {       //  fixed 2nd row
                counter = 0;
                for (int k = 0; k < n; k++) {
                    if (grid[i][k] == 1 && grid[j][k] == 1) counter++;
                }
                if (counter > 0) res += counter * (counter - 1) / 2;
            }
        }
        return res;
    }
}