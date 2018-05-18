package prob768.max.chunks.to.make.sorted.ii;

/**
 *  Created by yanya04 on 5/16/2018.
 */
public class Solution {
    public int maxChunksToSorted(int[] arr) {
        if(arr == null || arr.length == 0)
            return 0;
        int n = arr.length;
        int[] mins = new int[n];
        mins[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i --){
            mins[i] = Math.min(arr[i], mins[i + 1]);
        }

        int max = Integer.MIN_VALUE, count = 1;
        for(int i = 0; i < n - 1; i ++){
            max = Math.max(max, arr[i]);
            if(max <= mins[i + 1]){
                count ++;
            }
        }
        return count;

    }
}