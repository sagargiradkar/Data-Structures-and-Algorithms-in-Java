import java.util.Arrays;

public class D_17_Aggressive_Cows {
    public static void main(String[] args) {
        // Example test case
        int[] stalls = {1, 2, 8, 4, 9};
        int k = 3;

        // Call the function and display the result
        int result = Solution.aggressiveCows(stalls, k);
        System.out.println("The largest minimum distance is: " + result);
    }
}

// User function Template for Java
class Solution {
    static boolean isPossible(int stalls[], int k, int mid, int n) {
        int c = 1, prev = stalls[0];
        for (int i = 1; i < n; i++) {
            if (stalls[i] - prev >= mid) {
                c++;
                prev = stalls[i];
            }
        }
        return c >= k;
    }

    public static int aggressiveCows(int[] stalls, int k) {
        // Sort the stalls array
        Arrays.sort(stalls);
        int n = stalls.length, low = 0, high = stalls[n - 1] - stalls[0], mid, ans = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            if (isPossible(stalls, k, mid, n)) {
                ans = Math.max(ans, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
