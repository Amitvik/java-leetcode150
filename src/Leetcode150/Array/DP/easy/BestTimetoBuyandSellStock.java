package Leetcode150.Array.DP.easy;

public class BestTimetoBuyandSellStock {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyPrice = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                buyPrice = prices[i];
            } else {
                if (prices[i] < buyPrice) {
                    buyPrice = prices[i];
                } else {
                    int profit = prices[i] - buyPrice;
                    maxProfit = Math.max(profit, maxProfit);
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
