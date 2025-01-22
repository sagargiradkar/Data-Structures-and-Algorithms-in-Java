import java.util.*;

public class D_22_Highest_Peak {
    public static void main(String[] args) {
        int[][] isWater = {
            {0, 1},
            {0, 0}
        };

        Solution solution = new Solution();
        int[][] result = solution.highestPeak(isWater);

        System.out.println("Resulting height matrix:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        // Initialize the result matrix with -1 (unvisited land cells)
        int[][] height = new int[m][n];
        for (int[] row : height) {
            Arrays.fill(row, -1);
        }

        // BFS queue
        Queue<int[]> queue = new LinkedList<>();

        // Add all water cells to the queue with height 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    queue.add(new int[]{i, j});
                }
            }
        }

        // Directions for moving up, down, left, and right
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Perform BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int currentRow = cell[0];
            int currentCol = cell[1];

            for (int[] dir : directions) {
                int newRow = currentRow + dir[0];
                int newCol = currentCol + dir[1];

                // Check if the new cell is within bounds and unvisited
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && height[newRow][newCol] == -1) {
                    height[newRow][newCol] = height[currentRow][currentCol] + 1;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }

        return height;
    }
}
