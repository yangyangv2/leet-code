package prob265.paint.house.ii;

/**
 * Created by yanya04 on 1/22/2018.
 */
public class Solution {

    /*
        it's easy to go with O(n * k * k)

    */
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0)
            return 0;
        int n = costs.length, k = costs[0].length;
        for(int i = 1; i < n; i ++){
            //findMinNkk(costs, i);
            findMinNk(costs, i);
        }

        int res = Integer.MAX_VALUE;

        for(int i = 0; i < k; i ++){
            res = Math.min(res, costs[n - 1][i]);
        }
        return res;
    }


    /*
        keep the first/second min from the last step
    */
    private void findMinNk(int[][] costs, int index){

        // find first/second min
        int min1 = -1, min2 = -1;
        int k = costs[0].length;
        for(int i = 0; i < k; i ++){
            if(min1 < 0 || costs[index - 1][i] < costs[index - 1][min1]){
                min2 = min1;
                min1 = i;
            }
            else if(min2 < 0 || costs[index - 1][i] < costs[index - 1][min2])
                min2 = i;
        }
        for(int i = 0; i < k; i ++){
            if(i == min1){
                // use min2
                costs[index][i] += costs[index - 1][min2];

            } else {
                // use min 1
                costs[index][i] += costs[index - 1][min1];
            }
        }
    }



    // brute force
    private void findMinNkk(int[][] costs, int index) {
        int k = costs[0].length;
        for(int i = 0; i < k; i ++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < k; j ++){
                if(i == j) continue;
                min = Math.min(costs[index - 1][j], min);
            }
            costs[index][i] += min;
        }
    }
}
