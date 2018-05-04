package prob274.h.index;

import java.util.Arrays;

/**
 * Created by yanya04 on 8/13/2017.
 */
public class Solution {
    /*
        sort
       h-index = 5

        0 1 4 5 6
                h     (hit 1)       hit < cited => hit ++,
              h       (hit 2)       hit < cited => hit ++
            h         (hit 3)       hit < cited => hit ++
          h           return        hit > cited => end

    */
    public int hIndex(int[] citations) {
        return count(citations);
    }



    private int count(int[] citations){

        int n = citations.length;
        int[] count = new int[n + 1];
        for(int i = 0; i < n; i ++){
            count[Math.min(citations[i], n)] ++;
        }

        int res = 0;
        for(int i = n; i >= 0; i --){
            if(i < n) count[i] += count[i + 1];
            res = Math.max( res, Math.min(i, count[i]));
        }
        return res;
    }

    /*
        O(n)
    */
    private int sort(int[] citations){
        Arrays.sort(citations);
        int index = 0;

        // start from the end, because, every time
        // we confirm citations[i] >= index + 1, there's a guranteed index + 1 number of elements
        // larger than index + 1;

        for(int i = citations.length - 1; i >= 0; i --){
            if(citations[i] >= index + 1) index ++;
            else break;

        }
        return index;
    }




}