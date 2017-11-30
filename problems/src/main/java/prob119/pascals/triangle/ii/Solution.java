package prob119.pascals.triangle.ii;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    /*

        row[0]  1
        row[1]  1 1
        row[2]  1 2 1
        row[3]  1 3 3 1
        row[4]  1 4 6 4 1
        row[5]  1 5 10 5 1
        row[6]  0 1 6 15 15 6 1


    */

    public List<Integer> getRow(int rowIndex) {

        int[][] arr = new int[2][rowIndex + 2];

        arr[0][1] = 1;

        for(int i = 1; i <= rowIndex; i ++){
            for(int j = 1; j <= i + 1; j ++){
                arr[i % 2][j] = arr[(i + 1) % 2][j] + arr[(i + 1) % 2][j - 1];
            }
        }

        List<Integer> result = new ArrayList<>();

        for(int i = 1; i <= rowIndex + 1; i ++){
            result.add(arr[rowIndex % 2][i]);
        }

        return result;

    }
}