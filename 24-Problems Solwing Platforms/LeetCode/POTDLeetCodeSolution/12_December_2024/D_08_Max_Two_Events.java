// D_08_Max_Two_Events.java
import java.util.*;

public class D_08_Max_Two_Events {
    public static void main(String[] args) {
        int[][] events = {
            {1, 3, 4}, 
            {2, 5, 2}, 
            {4, 6, 7}
        };
        System.out.println("Maximum Value from Two Events: " + maxTwoEvents(events));
    }

    public static int maxTwoEvents(int[][] events) {
        int n = events.length;
        int[][] dp = new int[n + 1][3];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        return solve(events, 0, 0, n, dp);
    }

    private static int solve(int[][] events, int i, int count, int n, int[][] dp) {
        if (count == 2 || i >= n) {
            return 0;
        }

        if (dp[i][count] != -1) {
            return dp[i][count];
        }

        int nextValidEventIndex = binarySearch(events, events[i][1], n);
        int take = events[i][2] + solve(events, nextValidEventIndex, count + 1, n, dp);
        int notTake = solve(events, i + 1, count, n, dp);

        dp[i][count] = Math.max(take, notTake);
        return dp[i][count];
    }

    private static int binarySearch(int[][] events, int endTime, int n) {
        int left = 0, right = n - 1, result = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (events[mid][0] > endTime) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}
