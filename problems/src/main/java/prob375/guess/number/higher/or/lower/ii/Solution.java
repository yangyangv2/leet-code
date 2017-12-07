package prob375.guess.number.higher.or.lower.ii;

import static java.lang.Math.*;

public class Solution {

    public int getMoneyAmount(int n) {
        int[][] cost = new int[n + 1][n + 1];
        // cost[0][0] is not used
        return guess(cost, 1, n);
    }

    private int guess(int[][] cost, int s, int e){
        if(s >= e) return 0;

        if(cost[s][e] > 0) return cost[s][e];

        int result = Integer.MAX_VALUE;
        for(int i = s; i <= e; i ++){
            // when pick i;
            int temp = i + max(guess(cost, s, i - 1), guess(cost, i + 1, e));
            result = min(temp, result);
        }
        cost[s][e] = result;
        return result;
    }
}