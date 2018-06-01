package prob768.max.chunks.to.make.sorted.ii;

/**
 *  Created by yanya04 on 5/16/2018.
 *  Modified by yanya04 on 6/1/2018.
 */
public class Solution {
    /*
        a place is splitable when: max[..i] <= min[i + 1]..

            5,4,3,2,1
        min 5 4 3 2 1
        max 5 5 5 5 5

            2,1,3,4,4
        min 1,1,3,4,4
        max 2,2,3,4,4

    */
    public int maxChunksToSorted(int[] arr) {
        if(arr == null || arr.length == 0) return 0;

        int n = arr.length;
        int[] minRight = new int[n], maxLeft = new int[n];
        minRight[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i --){
            minRight[i] = Math.min(minRight[i + 1], arr[i]);
        }
        maxLeft[0] = arr[0];
        for(int i = 1; i < n; i ++){
            maxLeft[i] = Math.max(maxLeft[i - 1], arr[i]);
        }

        int chunks = 1;
        for(int i = 0; i < n - 1; i ++){
            if(maxLeft[i] <= minRight[i + 1]){
                chunks ++;
            }
        }
        return chunks;

    }
}