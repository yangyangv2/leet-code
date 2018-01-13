package prob134.gas.station;

/**
 * Created by yanya04 on 1/12/2018.
 */
public class Solution {
/*
     6        1       5
    g[1] -> g[2] -> g[3]
    c[1] -> c[2] -> c[3]
     5       10       4

     1       -9       1
*/
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || cost == null || gas.length != cost.length)
            return -1;
        int total = 0, sum = 0, start = 0;
        for(int i = 0; i < gas.length; i++){
            total += (gas[i] - cost[i]);

            sum +=  (gas[i] - cost[i]);
            if(sum < 0){
                start = i + 1;
                sum = 0;
            }
        }

        if(total < 0) return -1;
        else return start;

    }
}