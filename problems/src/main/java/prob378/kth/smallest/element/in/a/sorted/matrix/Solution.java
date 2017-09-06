package prob378.kth.smallest.element.in.a.sorted.matrix;

import java.util.Arrays;

/**
 * Created by yanya04 on 8/26/2017.
 */
public class Solution {

/*
    MovingAverage 1, a heap



    private static class Tuple implements Comparable<Tuple>{
        private int value;
        public Tuple(Integer value){
            this.value = value;
        }

        public int compareTo(Tuple obj){
            return obj.value - this.value;
        }

        public int getValue(){
            return this.value;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {

        PriorityQueue<Tuple> heap = new PriorityQueue<>();

        for(int i = 0; i < matrix.length; i ++){
            for(int j = 0; j < matrix[i].length; j ++){
                if(heap.size() == k && heap.peek().getValue() < matrix[i][j]){
                    continue;
                }
                heap.add(new Tuple(matrix[i][j]));
                if(heap.size() > k){
                    heap.poll();
                }
            }
        }
        return heap.peek().getValue();

    }
*/

/*
    MovingAverage 2

  */

    public int kthSmallest(int[][] matrix, int k) {

        int m = matrix.length, n = matrix[0].length;
        int lo = matrix[0][0], hi = matrix[m - 1][n - 1] + 1;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  j = n - 1;
            for(int i = 0; i < m; i++) {

                // find index j where matrix[i][j] is the last element <= target
                while(j >= 0 && matrix[i][j] > mid) j--;
                //j = binarySearch(matrix[i], mid);
                count += (j + 1);
            }
            if(count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }


    /*
        find the last one which is smaller than target
    */
    private int binarySearch(int[] array, int target){

        int result = Arrays.binarySearch(array, target);
        if(result < 0){
            return -2 - result;
        } else {
            while(result < array.length - 1 && array[result + 1] == array[result]) result ++;
            return result;
        }
    }



}
