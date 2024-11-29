import java.util.PriorityQueue;

public class D_29_Minimum_Time {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Simple grid
        int[][] grid1 = {
            {0, 1, 2},
            {1, 2, 3},
            {2, 3, 4}
        };
        System.out.println("Minimum time: " + solution.minimumTime(grid1)); // Output: 4

        // Test Case 2: Grid with inaccessible path
        int[][] grid2 = {
            {0, 3, 4},
            {2, 2, 5},
            {5, 7, 6}
        };
        System.out.println("Minimum time: " + solution.minimumTime(grid2)); // Output: -1

        // Test Case 3: Larger grid with delays
        int[][] grid3 = {
            {0, 1, 5, 6},
            {1, 3, 4, 5},
            {2, 4, 6, 7},
            {3, 5, 7, 8}
        };
        System.out.println("Minimum time: " + solution.minimumTime(grid3)); // Output: 8

        // Test Case 4: Edge case with minimal grid
        int[][] grid4 = {{0}};
        System.out.println("Minimum time: " + solution.minimumTime(grid4)); // Output: 0
    }
}

class Solution {
    public int minimumTime(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        boolean[][] visited = new boolean[m][n];

        pq.offer(new int[]{0, 0, 0}); // (time, x, y)

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], x = curr[1], y = curr[2];

            if (x == m - 1 && y == n - 1) return time;

            if (visited[x][y]) continue;
            visited[x][y] = true;

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    int wait = (grid[nx][ny] - time) % 2 == 0 ? 1 : 0;
                    int nextTime = Math.max(time + 1, grid[nx][ny] + wait);
                    pq.offer(new int[]{nextTime, nx, ny});
                }
            }
        }

        return -1; // Path not found
    }
}