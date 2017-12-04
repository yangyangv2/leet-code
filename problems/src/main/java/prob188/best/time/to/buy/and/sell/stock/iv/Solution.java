package prob188.best.time.to.buy.and.sell.stock.iv;

import static java.lang.Math.*;


public class Solution {


    private int greedysolve(int[] prices){
        int profit = 0;
        for(int i = 1; i < prices.length; i ++){

            if(prices[i] > prices[i - 1]){
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }


    public int maxProfit(int k, int[] prices) {

        if(k == 0 || prices == null || prices.length < 2) return 0;


        if(k >= prices.length / 2) return greedysolve(prices);


        int[] buys = new int[k];
        int[] sells = new int[k];


        for(int i = 0; i < k; i ++){
            buys[i] = Integer.MIN_VALUE;
            sells[i] = 0;
        }

        for(int price: prices){
            for(int i = 0; i < k - 1; i ++){
                sells[i] = max(sells[i], buys[i] + price);
                buys[i] = max(buys[i], sells[i + 1] - price);
            }
            sells[k - 1] = max(sells[k - 1], buys[k - 1] + price);
            buys[k - 1] = max(buys[k - 1], - price);
        }
        return sells[0];
    }
}