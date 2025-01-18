import java.util.*;

public class D_18_Min_Cost {
    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 3},
            {3, 2, 2},
            {1, 1, 4}
        };

        Solution solution = new Solution();
        int result = solution.minCost(grid);
        System.out.println("Minimum cost to make at least one valid path: " + result);
    }
}

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // Right, Left, Down, Up
        Deque<int[]> deque = new ArrayDeque<>();
        int[][] cost = new int[m][n];
        for (int[] row : cost) Arrays.fill(row, Integer.MAX_VALUE);

        deque.offer(new int[]{0, 0, 0}); // {row, col, cost}
        cost[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            int x = curr[0], y = curr[1], currCost = curr[2];

            // If we've reached the bottom-right corner
            if (x == m - 1 && y == n - 1) return currCost;

            for (int d = 0; d < 4; d++) {
                int nx = x + directions[d][0];
                int ny = y + directions[d][1];
                int newCost = currCost + (grid[x][y] == d + 1 ? 0 : 1); // No cost if direction matches

                if (nx >= 0 && ny >= 0 && nx < m && ny < n && newCost < cost[nx][ny]) {
                    cost[nx][ny] = newCost;
                    if (grid[x][y] == d + 1) {
                        deque.offerFirst(new int[]{nx, ny, newCost}); // Priority for no-cost moves
                    } else {
                        deque.offerLast(new int[]{nx, ny, newCost});
                    }
                }
            }
        }

        return -1; // Should never reach here
    }
}
