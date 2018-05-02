package prob309.best.time.to.buy.and.sell.stock.with.cooldown;

import static java.lang.Math.*;

public class Solution {

    /*
        state machine:

               (  )
               hold
              /    \
          (sell)   (buy)
           /          \
      sold -- (rest) -- rest
                         (  )

      hold[i] = max(hold[i - 1], rest[i - 1] - price[i]
      sold[i] = hold[i - 1] + price[i]
      rest[i] = max(rest[i - 1], sold[i - 1])
      optimization to space O(1)
    */

    public int maxProfit(int[] prices) {

        int n = prices.length;
        if(n < 2) return 0;

        int[] hold = new int[n];
        int[] sold = new int[n];
        int[] rest = new int[n];

        hold[0] = 0 - prices[0];
        sold[0] = 0;
        rest[0] = 0;

        for(int i = 1; i < n; i ++){
            hold[i] = Math.max(hold[i - 1], rest[i - 1] - prices[i]);
            rest[i] = Math.max(rest[i - 1], sold[i - 1]);
            sold[i] = hold[i - 1] + prices[i];
        }

        return Math.max(rest[n - 1], sold[n - 1]);

    }
}