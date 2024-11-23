public class D_21_Buy_Stock {
    public int maximumProfit(int prices[]) {
        // code here
        int ans = 0, n = prices.length;
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // Example usage
        D_21_Buy_Stock obj = new D_21_Buy_Stock();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum Profit: " + obj.maximumProfit(prices));
    }
}