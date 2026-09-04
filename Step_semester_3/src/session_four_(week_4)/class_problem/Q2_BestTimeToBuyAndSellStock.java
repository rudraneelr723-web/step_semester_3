public class Q2_BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int lowestPrice = prices[0];
        int maximumProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            }

            int currentProfit = prices[i] - lowestPrice;

            if (currentProfit > maximumProfit) {
                maximumProfit = currentProfit;
            }
        }

        return maximumProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices1));

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices2));
    }
}
