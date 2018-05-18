package prob769.max.chunks.to.make.sorted;

/**
 *  Created by yanya04 on 5/16/2018.
 */
public class Solution {

    /*
        arr = [1,0,2,3,4]
        max =  1 1 2 3 4
        idx =  1 0 2 3 4
        sot =  0 1 2 3 4
               0 1|2|3|4
    */
    public int maxChunksToSorted(int[] arr) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0; i < arr.length; i ++){
            if(max < arr[i]){
                max = arr[i];
                count ++;
            }
        }
        return count;
    }
}