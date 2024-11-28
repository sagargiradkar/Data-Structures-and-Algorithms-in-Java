
import java.util.*;

public class D_28_Minimum_Obstacles {

    public static void main(String[] args) {
        // Sample test case
        int[][] grid = {
            {0, 1, 1},
            {0, 1, 0},
            {0, 0, 0}
        };

        Solution solution = new Solution();
        int result = solution.minimumObstacles(grid);

        // Output the result
        System.out.println("Minimum obstacles removed to reach the bottom-right corner: " + result);
    }
}

class Solution {

    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Directions for moving in the grid
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Min-heap to store (removed_obstacles, x, y)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, 0, 0}); // (0 obstacles removed, start at 0,0)

        // Distance array to store minimum obstacles removed to reach each cell
        int[][] distance = new int[m][n];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int removed = current[0], x = current[1], y = current[2];

            // If we reach the bottom-right corner, return the result
            if (x == m - 1 && y == n - 1) {
                return removed;
            }

            // Explore neighbors
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                // Check bounds
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int newRemoved = removed + grid[nx][ny];
                    if (newRemoved < distance[nx][ny]) {
                        distance[nx][ny] = newRemoved;
                        pq.offer(new int[]{newRemoved, nx, ny});
                    }
                }
            }
        }

        return -1; // In case there's no valid path (shouldn't happen with constraints)
    }
}
