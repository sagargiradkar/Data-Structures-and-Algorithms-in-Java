import java.util.PriorityQueue;

public class Trapping_RainWater_II {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0; // Early return for empty heightMap
        }

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Initialize the min-heap with the boundary cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    minHeap.offer(new int[] { heightMap[i][j], i, j });
                    visited[i][j] = true; // Mark boundary cells as visited
                }
            }
        }

        int trappedWater = 0;
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } }; // Directions for moving in the grid

        // Process the min-heap
        while (!minHeap.isEmpty()) {
            int[] cell = minHeap.poll();
            int height = cell[0];
            int x = cell[1];
            int y = cell[2];

            // Check adjacent cells
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // If the new cell is within bounds and not visited
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                    // Calculate the water trapped
                    trappedWater += Math.max(0, height - heightMap[newX][newY]);
                    minHeap.offer(new int[] { Math.max(height, heightMap[newX][newY]), newX, newY });
                    visited[newX][newY] = true; // Mark as visited
                }
            }
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        Trapping_RainWater_II solution = new Trapping_RainWater_II();

        // Example Test Case 1
        int[][] heightMap1 = {
                { 1, 4, 3, 1, 3, 2 },
                { 3, 2, 1, 3, 2, 4 },
                { 2, 3, 3, 2, 3, 1 }
        };
        System.out.println("Trapped Rain Water Volume (Test Case 1): " + solution.trapRainWater(heightMap1)); // Output:
                                                                                                              // 4

        // Example Test Case 2
        int[][] heightMap2 = {
                { 3, 3, 3, 3, 3 },
                { 3, 2, 2, 2, 3 },
                { 3, 2, 1, 2, 3 },
                { 3, 2, 2, 2, 3 },
                { 3, 3, 3, 3, 3 }
        };
        System.out.println("Trapped Rain Water Volume (Test Case 2): " + solution.trapRainWater(heightMap2)); // Output:
                                                                                                              // 10
    }
}
