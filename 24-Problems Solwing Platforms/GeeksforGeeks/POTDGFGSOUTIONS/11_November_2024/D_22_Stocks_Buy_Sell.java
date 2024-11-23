import java.util.Scanner;

public class D_22_Stocks_Buy_Sell {

    public static int maxProfit(int[] prices) {
        int n = prices.length, buy = prices[0], profit = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] <= buy) {
                buy = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - buy);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of days:");
        int n = scanner.nextInt();
        int[] prices = new int[n];
        
        System.out.println("Enter the stock prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }
        
        int result = maxProfit(prices);
        System.out.println("Maximum profit: " + result);

        scanner.close();
    }
}