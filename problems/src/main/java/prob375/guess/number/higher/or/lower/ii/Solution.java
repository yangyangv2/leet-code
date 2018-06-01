package prob375.guess.number.higher.or.lower.ii;

import static java.lang.Math.*;

/**
 *  Created by yanya04 on 5/27/2018.
 *  Modified by yanya04 on 6/1/2018.
 */
public class Solution {

    /*
        guess[i][j] = min{ k + Math.max(guess[i][k - 1], guess[k + 1][j]) }
    */

    public int getMoneyAmount(int n) {
        int[][] costs = new int[n + 1][n + 1];
        return guess(costs, 1, n);
    }

    private int guess(int[][] costs, int s, int e){
        if(s >= e) return 0;
        if(costs[s][e] > 0) return costs[s][e];
        int cost = 0, min = Integer.MAX_VALUE;
        for(int k = s; k <= e; k ++){
            cost = k + Math.max(guess(costs, s, k - 1), guess(costs, k + 1, e));
            min = Math.min(cost, min);
        }
        costs[s][e] = min;
        return min;
    }
}