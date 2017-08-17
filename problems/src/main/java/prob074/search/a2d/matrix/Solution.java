package prob074.search.a2d.matrix;

/**
 * Created by yanya04 on 8/15/2017.
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null || matrix.length == 0 ||
                matrix[0] == null || matrix[0].length == 0){
            return false;
        }

        int m = matrix.length, n = matrix[0].length;
        int l = m * n;
        int lo = 0, hi = l - 1;

        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int value = matrix[mid / n][mid % n];
            if(value == target){
                return true;
            } else if(value < target){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }
}
