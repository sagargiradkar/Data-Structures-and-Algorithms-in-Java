import java.util.*;
public class D_28_Minimum_Cost {

    public static void main(String[] args) {
   
        // Sample input array
        int[] arr = {1, 4, 8, 11 };
        int k = 2; // Maximum allowed operations (jumps)

        int minimumCost = minimizeCost(k, arr);
        System.out.println("Minimum Cost: " + minimumCost);
    }

    public static int minimizeCost(int k, int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k && i + j < n; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + Math.abs(arr[i] - arr[i + j]));
            }
        }

        return dp[n - 1];
    }
}