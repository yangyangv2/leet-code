package prob568.maximum.vacation.days;

import java.util.Arrays;

/*
    Created by yanya04 on 5/24/2018.
 */
public class Solution {

    /*
        flights =       [city][city]  from city i to city j
            [0,1,1]
            [1,0,1]
            [1,1,0]

        days =          [city][week]
            [1,3,1]
            [6,0,3]
            [3,3,3]

        Output: 12
        Explanation:
        Ans = 6 + 3 + 3 = 12.



    */
    public int maxVacationDays(int[][] flights, int[][] days) {
        int cities = flights.length, weeks = days[0].length;
        int[][] cache = new int[cities][weeks];
        for(int i = 0; i < cities; i ++){
            Arrays.fill(cache[i], -1);
        }
        return dfs(flights, days, 0, 0, cache);
    }


    private int dfs(int[][] flights, int[][] days, int city, int week, int[][] cache){

        int cities = flights.length, weeks = days[0].length;

        if(week == weeks) return 0;

        if(cache[city][week] >= 0) return cache[city][week];

        int max = 0, temp = 0;
        for(int i = 0; i < cities; i ++){
            if(city == i || flights[city][i] == 1)
                temp = dfs(flights, days, i, week + 1, cache) + days[i][week];
            max = Math.max(max, temp);
        }

        cache[city][week] = max;
        return max;
    }
}
