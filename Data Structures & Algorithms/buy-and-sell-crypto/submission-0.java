class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;

        for(int i = 0; i < prices.length; i++){
            //check if prices at i is less than current min 
            min = Math.min(prices[i], min);
            max = Math.max(max, prices[i] - min);
        }

        return max;
    }
}