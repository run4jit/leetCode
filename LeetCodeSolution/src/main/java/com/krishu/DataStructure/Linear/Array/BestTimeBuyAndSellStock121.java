package com.krishu.DataStructure.Linear.Array;

import com.krishu.Utility;
/*
121. Best Time to Buy and Sell Stock
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.


Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104
 */
public class BestTimeBuyAndSellStock121 {

    public static int brute_force_maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }

    public static int maxProfit(int[] prices) {
        // keep the maximum profit
        int maxProfit = 0;
        // buy the first element from price array
        int buyingPrice = prices[0];
        // loop through each element from price array
        for (int i = 1; i < prices.length; i++) {
            // update the buying price with lower price stock
            if (buyingPrice > prices[i]) {
                buyingPrice = prices[i];
            } else {
                // compute the profit if next upcoming price is more
                int currentProfit = prices[i] - buyingPrice;
                // keep track of maximum profit.
                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }
        // return the max profit.
        return maxProfit;
    }
}


class Solution121 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    static void test1() {
        int[] stockPices = {7,1,5,3,6,4};

        int expected = 5;
        int actual = BestTimeBuyAndSellStock121.brute_force_maxProfit(stockPices);
        Utility.printException(expected, actual);

    }

    static void test2() {
        int[] stockPices = {7,1,5,3,6,4};

        int expected = 5;
        int actual = BestTimeBuyAndSellStock121.maxProfit(stockPices);
        Utility.printException(expected, actual);

    }

    static void test3() {
        int[] stockPices = {7,6,4,3,1};

        int expected = 0;
        int actual = BestTimeBuyAndSellStock121.maxProfit(stockPices);
        Utility.printException(expected, actual);

    }

}