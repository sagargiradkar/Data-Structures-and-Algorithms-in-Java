import java.util.PriorityQueue;

public class D_19_Trap_Rain_Water {
    public static void main(String[] args) {
        int[][] heightMap = {
            {1, 4, 3, 1, 3, 2},
            {3, 2, 1, 3, 2, 4},
            {2, 3, 3, 2, 3, 1}
        };

        Solution solution = new Solution();
        int result = solution.trapRainWater(heightMap);
        System.out.println("Total water trapped: " + result);
    }
}

class Solution {
    private static class Cell {
        int row, col, height;

        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.height - b.height);

        // Add all border cells to the priority queue and mark them as visited
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    pq.offer(new Cell(i, j, heightMap[i][j]));
                    visited[i][j] = true;
                }
            }
        }

        // Directions for moving to adjacent cells
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int waterTrapped = 0;

        while (!pq.isEmpty()) {
            Cell cell = pq.poll();
            for (int[] dir : directions) {
                int newRow = cell.row + dir[0];
                int newCol = cell.col + dir[1];

                // Skip out-of-bound or already visited cells
                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || visited[newRow][newCol]) {
                    continue;
                }

                // Calculate trapped water
                waterTrapped += Math.max(0, cell.height - heightMap[newRow][newCol]);

                // Update the height of the neighbor and add it to the queue
                pq.offer(new Cell(newRow, newCol, Math.max(cell.height, heightMap[newRow][newCol])));
                visited[newRow][newCol] = true;
            }
        }

        return waterTrapped;
    }
}
