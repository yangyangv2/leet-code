package prob134.gas.station;

/**
 * Created by yanya04 on 1/12/2018.
 * Modified by yanya04 on 5/28/2018.
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, sum = 0, n = gas.length;
        if(n == 0) return -1;
        int start = 0, balance = 0;
        for(int i = 0; i < n; i ++){
            balance = gas[i] - cost[i];
            total += balance;
            sum += balance;
            if(sum < 0){
                start = i + 1;
                sum = 0;
            }
        }
        if(total < 0) return -1;
        return start;
    }
}