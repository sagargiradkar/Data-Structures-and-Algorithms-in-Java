public class D_21_Grid_Game {
    public static void main(String[] args) {
        int[][] grid = {
            {2, 5, 4},
            {1, 5, 1}
        };

        Solution solution = new Solution();
        long result = solution.gridGame(grid);
        System.out.println("Minimum points the second robot can collect: " + result);
    }
}

class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;

        // Calculate prefix sums for the top and bottom rows
        long[] topPrefix = new long[n];
        long[] bottomPrefix = new long[n];

        topPrefix[0] = grid[0][0];
        bottomPrefix[0] = grid[1][0];
        for (int i = 1; i < n; i++) {
            topPrefix[i] = topPrefix[i - 1] + grid[0][i];
            bottomPrefix[i] = bottomPrefix[i - 1] + grid[1][i];
        }

        long result = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            // Points remaining in the top row after column i
            long topRemaining = (i == n - 1) ? 0 : topPrefix[n - 1] - topPrefix[i];
            // Points remaining in the bottom row before column i
            long bottomRemaining = (i == 0) ? 0 : bottomPrefix[i - 1];

            // Maximum points the second robot can collect
            long secondRobotPoints = Math.max(topRemaining, bottomRemaining);

            // Minimize the maximum points the second robot can collect
            result = Math.min(result, secondRobotPoints);
        }

        return result;
    }
}
