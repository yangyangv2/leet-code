package prob375.guess.number.higher.or.lower.ii;

import static java.lang.Math.*;

/**
 *  Created by yanya04 on 5/27/2018.
 */
public class Solution {

    /*
        top down
        bruteforce
        min-max
    */
    public int getMoneyAmount(int n) {
        if(n == 0) return 0;
        int[][] costs = new int[n + 1][n + 1];
        return guess(1, n, costs);
    }

    private int guess(int s, int e, int[][] costs){
        if(s >= e) return 0;
        if(costs[s][e] > 0) return costs[s][e];

        int min = Integer.MAX_VALUE;
        for(int i = s; i <= e; i ++){
            int temp = i + Math.max(guess(s, i - 1, costs), guess(i + 1, e, costs));
            min = Math.min(temp, min);
        }
        costs[s][e] = min;
        return min;
    }
}