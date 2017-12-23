package prob123.best.time.to.buy.and.sell.stock.iii;

import static java.lang.Math.*;
public class Solution {
    public int maxProfit(int[] prices) {
        // buy1, buy2 are profits after 1st/2nd buy
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        // sell1, sell2 are profits after sell1, sell2
        int sell1 = 0, sell2 = 0;

        for(int price: prices){
            sell2 = max(sell2, buy2 + price);
            buy2 = max(buy2, sell1 - price);

            sell1 = max(sell1, buy1 + price);
            buy1 = max(buy1, -price);
        }
        return sell2;
    }
}