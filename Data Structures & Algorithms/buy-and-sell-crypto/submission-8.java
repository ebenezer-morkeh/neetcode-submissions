class Solution {
    public int maxProfit(int[] prices) {
        // two pointers
        // looking for max , aka Math.max
        int minPrice = Integer.MAX_VALUE;
        int best = 0;

        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice){
                minPrice = prices[i];
            } else {
                best = Math.max(best, prices[i] - minPrice);
            }
        }

        return best;
    }
}
